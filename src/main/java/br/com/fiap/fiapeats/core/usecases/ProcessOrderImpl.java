package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.*;
import br.com.fiap.fiapeats.core.exceptions.ClientNotFoundException;
import br.com.fiap.fiapeats.core.exceptions.FillOrderPropertiesException;
import br.com.fiap.fiapeats.core.exceptions.ProductNotFoundException;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.ports.out.FeignCreatePaymentPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindClientPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProcessOrderImpl implements ProcessOrderPort {

  private final FeignFindProductsPort feignFindProductsPort;

  private final SaveOrderPort saveOrderPort;

  private final FeignFindClientPort feignFindClientPort;

  private final FeignCreatePaymentPort feignCreatePaymentPort;

  public ProcessOrderImpl(
      FeignFindProductsPort feignFindProductsPort,
      SaveOrderPort saveOrderPort,
      FeignFindClientPort feignFindClientPort,
      FeignCreatePaymentPort feignCreatePaymentPort) {
    this.feignFindProductsPort = feignFindProductsPort;
    this.saveOrderPort = saveOrderPort;
    this.feignFindClientPort = feignFindClientPort;
    this.feignCreatePaymentPort = feignCreatePaymentPort;
  }

  @Override
  public Order process(Order order)
      throws FillOrderPropertiesException, ClientNotFoundException, ProductNotFoundException {
    order.setId(UUID.randomUUID());
    List<Product> feignProducts = feignFindProductsPort.getAllProducts();

    validPorductItens(feignProducts, order);

    validClient(order);

    order.setQrCode(
        feignCreatePaymentPort.createPayment(
            new Payment("cb2614b9-171c-4792-83d3-9fcdeef4e9ee", "https://teste.com.br")));

    saveOrderPort.save(fillOrderProperties(order, feignProducts));

    return order;
  }

  private void validPorductItens(List<Product> products, Order order)
      throws ProductNotFoundException {
    if (!order.getProducts().stream()
        .map(Product::getId)
        .allMatch(products.stream().map(Product::getId).collect(Collectors.toSet())::contains))
      throw new ProductNotFoundException(Constants.TXT_PRODUCT_NOT_FOUND);
  }

  void validClient(Order order) throws ClientNotFoundException {
    if (order.getTaxId() == null) {
      order.setTaxId("");
      return;
    }
    try {
      feignFindClientPort.findClient(order.getTaxId());
    } catch (Exception e) {
      throw new ClientNotFoundException(Constants.TXT_CLIENT_NOT_FOUND);
    }
  }

  private Order fillOrderProperties(Order order, List<Product> feignProducts)
      throws FillOrderPropertiesException {
    order.setOrderStatus(Constants.PENDING);
    order.setPaymentStatus(Constants.PENDING);
    order.setCreateTimestamp(LocalDateTime.now());
    order.setTimeWaiting(10);
    Map<UUID, Product> mapProduct = new HashMap<>();
    for (Product item : feignProducts) {
      mapProduct.put(item.getId(), item);
    }

    for (int i = 0; i < order.getProducts().size(); i++) {
      try {
        Product p = mapProduct.get(order.getProducts().get(i).getId());
        order.getProducts().get(i).setDescription(p.getDescription());
        order.getProducts().get(i).setValue(p.getValue());
        order.getProducts().get(i).setName(p.getName());
        order.getProducts().get(i).setImageUrl(p.getImageUrl());
        order
            .getProducts()
            .get(i)
            .setCategory(
                new Category(
                    p.getCategory().getId() == null ? 0L : p.getCategory().getId(),
                    p.getCategory().getDescription()));
      } catch (Exception e) {
        throw new FillOrderPropertiesException(e.getMessage());
      }
    }
    return order;
  }
}

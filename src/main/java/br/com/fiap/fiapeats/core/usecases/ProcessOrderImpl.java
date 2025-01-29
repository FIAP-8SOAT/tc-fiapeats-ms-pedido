package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Payment;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.ports.out.FeignCreatePaymentPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindClientPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.webjars.NotFoundException;

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
  public void process(Order order) {
    order.setId(UUID.randomUUID());
    List<Product> feignProducts = feignFindProductsPort.getAllProducts();

    validPorductItens(feignProducts, order);

    validClient(order);

    order.setQrCode(
        feignCreatePaymentPort.createPayment(
            new Payment("cb2614b9-171c-4792-83d3-9fcdeef4e9ee", "https://teste.com.br")));

    order.getProducts().get(0).setDescription("cachorro quente");
    saveOrderPort.save(order);

    // TODO: retornar qrCode para pagamento ao cliente
  }

  void validPorductItens(List<Product> products, Order order) {
    if (!order.getProducts().stream()
        .map(Product::getId)
        .allMatch(products.stream().map(Product::getId).collect(Collectors.toSet())::contains))
      throw new NotFoundException("Existem produtos na lista que não estão na base");
  }

  void validClient(Order order) {
    feignFindClientPort.findClient(order.getTaxId());
  }
}

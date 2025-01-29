package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
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

  public ProcessOrderImpl(
      FeignFindProductsPort feignFindProductsPort,
      SaveOrderPort saveOrderPort,
      FeignFindClientPort feignFindClientPort) {
    this.feignFindProductsPort = feignFindProductsPort;
    this.saveOrderPort = saveOrderPort;
    this.feignFindClientPort = feignFindClientPort;
  }

  @Override
  public void process(Order order) {
    List<Product> feignProducts = feignFindProductsPort.getAllProducts();

    validPorductItens(feignProducts, order);

    validClient(order);

    // TODO: mandar para pagamento

    // TODO: gravar no banco
    order.setId(UUID.randomUUID());
    order.getProducts().get(0).setDescription("cachorro quente");
    saveOrderPort.save(order);
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

package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.in.CreateOrderPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;

import java.util.List;

public class CreateOrderImpl implements CreateOrderPort {

  private final FeignFindProductsPort feignFindProductsPort;

  public CreateOrderImpl(FeignFindProductsPort feignFindProductsPort) {
    this.feignFindProductsPort = feignFindProductsPort;
  }

  @Override
  public String create(Order order) {
    String name = order.getProducts().get(0).getName();
    List<Product> products = feignFindProductsPort.getAllProducts();
    return "valido";
  }
}

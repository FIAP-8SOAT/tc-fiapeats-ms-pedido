package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.webjars.NotFoundException;

public class ProcessOrderImpl implements ProcessOrderPort {

  private final FeignFindProductsPort feignFindProductsPort;

  private final SaveOrderPort saveOrderPort;

  public ProcessOrderImpl(
      FeignFindProductsPort feignFindProductsPort, SaveOrderPort saveOrderPort) {
    this.feignFindProductsPort = feignFindProductsPort;
    this.saveOrderPort = saveOrderPort;
  }

  @Override
  public void process(Order order) {
    List<Product> products = feignFindProductsPort.getAllProducts();

    Set<UUID> idsFeign = products.stream().map(Product::getId).collect(Collectors.toSet());

    boolean allPresent =
        order.getProducts().stream().map(Product::getId).allMatch(idsFeign::contains);

    if (!allPresent) throw new NotFoundException("Existem produtos na lista que não estão na base");

    // TODO: validar se o usuario tem na request e existe

    // TODO: mandar para pagamento

    // TODO: gravar no banco
    order.setId(UUID.randomUUID());
    order.getProducts().get(0).setDescription("cachorro quente");
    saveOrderPort.save(order);
    String a = "a";
  }
}

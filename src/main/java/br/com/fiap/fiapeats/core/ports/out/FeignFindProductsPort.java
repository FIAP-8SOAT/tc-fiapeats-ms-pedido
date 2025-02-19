package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Product;
import java.util.List;

public interface FeignFindProductsPort {
  List<Product> getAllProducts();
}

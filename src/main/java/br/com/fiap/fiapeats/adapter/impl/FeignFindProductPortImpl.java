package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.FeignProductMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindProducts;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FeignFindProductPortImpl implements FeignFindProductsPort {

  private final FeignFindProducts feignFindProducts;
  private final FeignProductMapper feignProductMapper;

  public FeignFindProductPortImpl(
      FeignFindProducts feignFindProducts, FeignProductMapper feignProductMapper) {
    this.feignFindProducts = feignFindProducts;
    this.feignProductMapper = feignProductMapper;
  }

  @Override
  public List<Product> getAllProducts() {
    return feignProductMapper.toProductListFromFeignProductList(feignFindProducts.getAllProducts());
  }
}

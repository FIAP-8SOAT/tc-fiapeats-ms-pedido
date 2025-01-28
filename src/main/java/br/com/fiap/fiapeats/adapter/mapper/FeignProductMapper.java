package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FeignProductMapper {

  @Mapping(source = "category", target = "category", qualifiedByName = "mapCategory")
  Product toProductFromFeignProduct(FeignFindProductsResponse response);

  @Named("mapCategory")
  static Category mapCategory(String categoryName) {
    if (categoryName == null) {
      return null;
    }
    return new Category(null, categoryName);
  }

  List<Product> toProductListFromFeignProductList(List<FeignFindProductsResponse> responses);
}

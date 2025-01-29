package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.OrderRequest;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.ProductDocument;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idStatus", ignore = true)
  @Mapping(target = "createTimestamp", ignore = true)
  @Mapping(target = "timeWaiting", ignore = true)
  @Mapping(target = "products", source = "idProducts", qualifiedByName = "mapIdsToProducts")
  Order toOrderFromOrderRequest(OrderRequest orderRequest);

  @Named("mapIdsToProducts")
  static List<Product> mapIdsToProducts(List<UUID> ids) {
    return ids.stream().map(Product::new).toList();
  }

  @Mapping(
      target = "products",
      source = "products",
      qualifiedByName = "toListProducDocumentFromListProduct")
  OrderDocument toOrderDocumentFromOrder(Order order);

  @Named("toListProducDocumentFromListProduct")
  static List<ProductDocument> toListProducDocumentFromListProduct(List<Product> products) {
    return products.stream()
        .map(
            product ->
                new ProductDocument(
                    product.getId().toString(),
                    product.getName(),
                    product.getDescription(),
                    product.getValue(),
                    product.getCategory(),
                    product.getImageUrl()))
        .toList();
  }
}

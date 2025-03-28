package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CreateOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.OrderResponse;
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
  @Mapping(target = "orderStatus", ignore = true)
  @Mapping(target = "createTimestamp", ignore = true)
  @Mapping(target = "timeWaiting", ignore = true)
  @Mapping(target = "qrCode", ignore = true)
  @Mapping(target = "paymentStatus", ignore = true)
  @Mapping(target = "paymentId", ignore = true)
  @Mapping(target = "products", source = "idProducts", qualifiedByName = "mapIdsToProducts")
  Order toOrderFromOrderRequest(CreateOrderRequest createOrderRequest);

  @Named("mapIdsToProducts")
  static List<Product> mapIdsToProducts(List<UUID> ids) {
    return ids.stream().map(Product::new).toList();
  }

  @Mapping(
      target = "products",
      source = "products",
      qualifiedByName = "toListProducDocumentFromListProduct")
  @Mapping(target = "payment.paymentStatus", source = "paymentStatus")
  @Mapping(target = "payment.qrCode", source = "qrCode")
  @Mapping(target = "payment.paymentId", source = "paymentId")
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

  @Mapping(target = "qrCode", source = "qrCode")
  @Mapping(target = "orderId", source = "id")
  @Mapping(target = "status", source = "orderStatus")
  CreateOrderResponse toCreateOrderResponseFromOrder(Order order);

  @Mapping(
      target = "products",
      source = "products",
      qualifiedByName = "toListProducFromListProductDocument")
  @Mapping(target = "paymentStatus", source = "payment.paymentStatus")
  @Mapping(target = "qrCode", source = "payment.qrCode")
  @Mapping(target = "paymentId", source = "payment.paymentId")
  Order toOrderFromOrderDocument(OrderDocument orderDocument);

  @Named("toListProducFromListProductDocument")
  static List<Product> toListProducFromListProductDocument(List<ProductDocument> productsD) {
    return productsD.stream()
        .map(
            product ->
                new Product(
                    UUID.fromString(product.getId()),
                    product.getName(),
                    product.getDescription(),
                    product.getValue(),
                    product.getCategory(),
                    product.getImageUrl()))
        .toList();
  }

  OrderResponse toOrderResponseFromOrder(Order order);
}

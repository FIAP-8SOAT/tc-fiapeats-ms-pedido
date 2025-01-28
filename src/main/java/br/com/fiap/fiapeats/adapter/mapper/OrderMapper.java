package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.OrderRequest;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

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
}

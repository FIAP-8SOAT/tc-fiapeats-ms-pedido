package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.OrderRequest;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-28T16:14:42-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrderFromOrderRequest(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        List<Product> products = null;
        String taxId = null;
        BigDecimal value = null;

        products = OrderMapper.mapIdsToProducts( orderRequest.getIdProducts() );
        taxId = orderRequest.getTaxId();
        value = orderRequest.getValue();

        UUID id = null;
        Long idStatus = null;
        LocalDateTime createTimestamp = null;
        int timeWaiting = 0;

        Order order = new Order( id, products, taxId, value, idStatus, createTimestamp, timeWaiting );

        return order;
    }
}

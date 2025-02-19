package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateOrderRequestTest {

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        BigDecimal value = new BigDecimal(100);
        String taxId = "123.456.789-00";
        UUID product = UUID.randomUUID();

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setIdProducts(List.of(product));
        createOrderRequest.setTaxId(taxId);
        createOrderRequest.setValue(value);

        CreateOrderRequest createOrderRequest2 = new CreateOrderRequest();
        createOrderRequest2.setIdProducts(List.of(product));
        createOrderRequest2.setTaxId(taxId);
        createOrderRequest2.setValue(value);

        assertEquals(createOrderRequest, createOrderRequest2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        BigDecimal value = new BigDecimal(100);
        String taxId = "123.456.789-00";
        UUID product = UUID.randomUUID();

        CreateOrderRequest createOrderRequest = CreateOrderRequest.builder().build();
        createOrderRequest.setIdProducts(List.of(product));
        createOrderRequest.setTaxId(taxId);
        createOrderRequest.setValue(value);

        CreateOrderRequest createOrderRequest2 = CreateOrderRequest.builder().build();
        createOrderRequest2.setIdProducts(List.of(product));
        createOrderRequest2.setTaxId(taxId);
        createOrderRequest2.setValue(value);

        assertEquals(createOrderRequest.hashCode(), createOrderRequest2.hashCode());
    }
}

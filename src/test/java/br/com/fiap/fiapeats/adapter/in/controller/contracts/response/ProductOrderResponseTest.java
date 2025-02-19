package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductOrderResponseTest {

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        UUID id = UUID.randomUUID();
        String name = "product";
        BigDecimal value = new BigDecimal(100);

        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse response = ProductOrderResponse.builder().build();
        response.setId(id);
        response.setName(name);
        response.setCategory(categoryOrderResponse);
        response.setValue(value);
        response.setDescription(name);
        response.setImageUrl("image-url");

        ProductOrderResponse response2 = ProductOrderResponse.builder().build();
        response2.setId(id);
        response2.setName(name);
        response2.setCategory(categoryOrderResponse);
        response2.setValue(value);
        response2.setDescription(name);
        response2.setImageUrl("image-url");

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        UUID id = UUID.randomUUID();
        String name = "product";
        BigDecimal value = new BigDecimal(100);

        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse response = ProductOrderResponse.builder().build();
        response.setId(id);
        response.setName(name);
        response.setCategory(categoryOrderResponse);
        response.setValue(value);
        response.setDescription(name);
        response.setImageUrl("image-url");

        ProductOrderResponse response2 = ProductOrderResponse.builder().build();
        response2.setId(id);
        response2.setName(name);
        response2.setCategory(categoryOrderResponse);
        response2.setValue(value);
        response2.setDescription(name);
        response2.setImageUrl("image-url");

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

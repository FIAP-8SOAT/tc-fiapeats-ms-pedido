package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CategoryOrderResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryOrderResponseTest {

    @Test
    void testCategoryOrderResponse() {
        Long id = 1L;
        String description = "Bebida";

        CategoryOrderResponse response = CategoryOrderResponse.builder()
                        .id(id)
                .description(description)
                .build();

        assertEquals(id, response.getId());
        assertEquals(description, response.getDescription());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        Long id = 1L;
        String description = "Bebida";

        CategoryOrderResponse response = CategoryOrderResponse.builder()
                .id(id)
                .description(description)
                .build();

        CategoryOrderResponse response2 = CategoryOrderResponse.builder()
                .id(id)
                .description(description)
                .build();

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        Long id = 1L;
        String description = "Bebida";

        CategoryOrderResponse response = CategoryOrderResponse.builder()
                .id(id)
                .description(description)
                .build();

        CategoryOrderResponse response2 = CategoryOrderResponse.builder()
                .id(id)
                .description(description)
                .build();

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

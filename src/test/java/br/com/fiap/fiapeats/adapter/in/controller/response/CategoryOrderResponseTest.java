package br.com.fiap.fiapeats.adapter.in.controller.response;

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
}

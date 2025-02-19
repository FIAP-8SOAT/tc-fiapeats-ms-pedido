package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeignFindProductsCategoryResponseTest {

    @Test
    void testToString() {
        FeignFindProductsCategoryResponse response = FeignFindProductsCategoryResponse.builder().build();
        response.setId("12345");
        response.setDescription("product");

        String expectedString = "FeignFindProductsCategoryResponse(" +
                "id=12345" +
                ", description=product" +
                ')';

        assertEquals(expectedString, response.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        FeignFindProductsCategoryResponse response = FeignFindProductsCategoryResponse.builder().build();
        response.setId("12345");
        response.setDescription("product");

        FeignFindProductsCategoryResponse response2 = FeignFindProductsCategoryResponse.builder().build();
        response2.setId("12345");
        response2.setDescription("product");

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        FeignFindProductsCategoryResponse response = FeignFindProductsCategoryResponse.builder().build();
        response.setId("12345");
        response.setDescription("product");

        FeignFindProductsCategoryResponse response2 = FeignFindProductsCategoryResponse.builder().build();
        response2.setId("12345");
        response2.setDescription("product");

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FeignFindProductsResponseTest {

    @Test
    void testConstructorAndGetters() {
        FeignFindProductsCategoryResponse category = new FeignFindProductsCategoryResponse("1", "Categoria 1");

        FeignFindProductsResponse response = FeignFindProductsResponse.builder()
                .id("prod1")
                .name("Produto 1")
                .description("Descrição do produto 1")
                .value(new BigDecimal("100.00"))
                .category(category)
                .imageUrl("http://example.com/produto1.jpg")
                .build();

        assertEquals("prod1", response.getId());
        assertEquals("Produto 1", response.getName());
        assertEquals("Descrição do produto 1", response.getDescription());
        assertEquals(new BigDecimal("100.00"), response.getValue());
        assertEquals(category, response.getCategory());
        assertEquals("http://example.com/produto1.jpg", response.getImageUrl());
    }

    @Test
    void testNoArgsConstructor() {
        FeignFindProductsResponse response = new FeignFindProductsResponse();

        assertNull(response.getId());
        assertNull(response.getName());
        assertNull(response.getDescription());
        assertNull(response.getValue());
        assertNull(response.getCategory());
        assertNull(response.getImageUrl());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        String id = UUID.randomUUID().toString();
        String name = "produto";
        BigDecimal value = new BigDecimal(100);
        String image = "url_image";

        FeignFindProductsCategoryResponse feignFindProductsCategoryResponse = new FeignFindProductsCategoryResponse();
        feignFindProductsCategoryResponse.setId("1");
        feignFindProductsCategoryResponse.setDescription("Bebida");

        FeignFindProductsResponse feignFindProductsResponse = FeignFindProductsResponse.builder().build();
        feignFindProductsResponse.setId(id);
        feignFindProductsResponse.setName(name);
        feignFindProductsResponse.setDescription(name);
        feignFindProductsResponse.setValue(value);
        feignFindProductsResponse.setCategory(feignFindProductsCategoryResponse);
        feignFindProductsResponse.setImageUrl(image);

        FeignFindProductsResponse feignFindProductsResponse2 = FeignFindProductsResponse.builder().build();
        feignFindProductsResponse2.setId(id);
        feignFindProductsResponse2.setName(name);
        feignFindProductsResponse2.setDescription(name);
        feignFindProductsResponse2.setValue(value);
        feignFindProductsResponse2.setCategory(feignFindProductsCategoryResponse);
        feignFindProductsResponse2.setImageUrl(image);

        assertEquals(feignFindProductsResponse, feignFindProductsResponse2);
    }

    @Test
    void testToString() {
        String id = UUID.randomUUID().toString();
        String name = "produto";
        BigDecimal value = new BigDecimal(100);
        String image = "url_image";

        FeignFindProductsCategoryResponse feignFindProductsCategoryResponse = new FeignFindProductsCategoryResponse();
        feignFindProductsCategoryResponse.setId("1");
        feignFindProductsCategoryResponse.setDescription("Bebida");

        FeignFindProductsResponse feignFindProductsResponse = new FeignFindProductsResponse();
        feignFindProductsResponse.setId(id);
        feignFindProductsResponse.setName(name);
        feignFindProductsResponse.setDescription(name);
        feignFindProductsResponse.setValue(value);
        feignFindProductsResponse.setCategory(feignFindProductsCategoryResponse);
        feignFindProductsResponse.setImageUrl(image);

        String expectedString = "FeignFindProductsResponse(" +
                "id=" + id +
                ", name=produto" +
                ", description=produto" +
                ", value=100" +
                ", category=" + feignFindProductsCategoryResponse +
                ", imageUrl=url_image" +
                ')';

        assertEquals(expectedString, feignFindProductsResponse.toString());
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        String id = UUID.randomUUID().toString();
        String name = "produto";
        BigDecimal value = new BigDecimal(100);
        String image = "url_image";

        FeignFindProductsCategoryResponse feignFindProductsCategoryResponse = new FeignFindProductsCategoryResponse();
        feignFindProductsCategoryResponse.setId("1");
        feignFindProductsCategoryResponse.setDescription("Bebida");

        FeignFindProductsResponse feignFindProductsResponse = new FeignFindProductsResponse();
        feignFindProductsResponse.setId(id);
        feignFindProductsResponse.setName(name);
        feignFindProductsResponse.setDescription(name);
        feignFindProductsResponse.setValue(value);
        feignFindProductsResponse.setCategory(feignFindProductsCategoryResponse);
        feignFindProductsResponse.setImageUrl(image);

        FeignFindProductsResponse feignFindProductsResponse2 = new FeignFindProductsResponse();
        feignFindProductsResponse2.setId(id);
        feignFindProductsResponse2.setName(name);
        feignFindProductsResponse2.setDescription(name);
        feignFindProductsResponse2.setValue(value);
        feignFindProductsResponse2.setCategory(feignFindProductsCategoryResponse);
        feignFindProductsResponse2.setImageUrl(image);

        assertEquals(feignFindProductsResponse.hashCode(), feignFindProductsResponse2.hashCode());
    }
}

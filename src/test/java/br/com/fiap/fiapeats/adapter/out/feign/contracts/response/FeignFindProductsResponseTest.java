package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeignFindProductsResponseTest {

    private FeignFindProductsResponse product;

    @BeforeEach
    void setUp() {
        product = FeignFindProductsResponse.builder()
                .id("12345")
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new FeignFindProductsCategoryResponse("1", "Category A"))
                .imageUrl("http://image.url")
                .build();
    }

    @Test
    void testGettersAndSetters() {
        FeignFindProductsResponse newProduct = new FeignFindProductsResponse();
        newProduct.setId("67890");
        newProduct.setName("Product B");
        newProduct.setDescription("Description of Product B");
        newProduct.setValue(BigDecimal.valueOf(49.99));
        newProduct.setCategory(new FeignFindProductsCategoryResponse("1", "Category A"));
        newProduct.setImageUrl("http://image.url/b");

        assertThat(newProduct.getId()).isEqualTo("67890");
        assertThat(newProduct.getName()).isEqualTo("Product B");
        assertThat(newProduct.getDescription()).isEqualTo("Description of Product B");
        assertThat(newProduct.getValue()).isEqualByComparingTo(BigDecimal.valueOf(49.99));
        assertThat(newProduct.getCategory().getDescription()).isEqualTo("Category A");
        assertThat(newProduct.getImageUrl()).isEqualTo("http://image.url/b");
    }

    @Test
    void testBuilder() {
        assertThat(product.getId()).isEqualTo("12345");
        assertThat(product.getName()).isEqualTo("Product A");
        assertThat(product.getDescription()).isEqualTo("Description of Product A");
        assertThat(product.getValue()).isEqualByComparingTo(BigDecimal.valueOf(29.99));
        assertThat(product.getCategory().getDescription()).isEqualTo("Category A");
        assertThat(product.getImageUrl()).isEqualTo("http://image.url");
    }

    @Test
    void testEqualsAndHashCode() {
        FeignFindProductsResponse product1 = FeignFindProductsResponse.builder()
                .id("12345")
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new FeignFindProductsCategoryResponse("1", "Category A"))
                .imageUrl("http://image.url")
                .build();

        FeignFindProductsResponse product2 = FeignFindProductsResponse.builder()
                .id("12345")
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new FeignFindProductsCategoryResponse("1", "Category A"))
                .imageUrl("http://image.url")
                .build();

        FeignFindProductsResponse product3 = FeignFindProductsResponse.builder()
                .id("67890")
                .name("Product B")
                .description("Description of Product B")
                .value(BigDecimal.valueOf(49.99))
                .category(new FeignFindProductsCategoryResponse("1", "Category A"))
                .imageUrl("http://image.url/b")
                .build();

        assertThat(product1).isEqualTo(product2);
        assertThat(product1.hashCode()).isEqualTo(product2.hashCode());
        assertThat(product1).isNotEqualTo(product3);
        assertThat(product1.hashCode()).isNotEqualTo(product3.hashCode());
    }

    @Test
    void testToString2() {
        String toString = product.toString();
        assertThat(toString).contains("id=12345").contains("name=Product A").contains("description=Description of Product A").contains("value=29.99");
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

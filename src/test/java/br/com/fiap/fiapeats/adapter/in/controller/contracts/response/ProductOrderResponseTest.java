package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOrderResponseTest {

    private ProductOrderResponse product;

    @BeforeEach
    void setUp() {
        product = ProductOrderResponse.builder()
                .id(UUID.randomUUID())
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new CategoryOrderResponse(1L, "Category A"))
                .imageUrl("http://image.url")
                .build();
    }

    @Test
    void testGettersAndSetters() {
        ProductOrderResponse newProduct = ProductOrderResponse.builder().build();
        UUID id = UUID.randomUUID();
        newProduct.setId(id);
        newProduct.setName("Product B");
        newProduct.setDescription("Description of Product B");
        newProduct.setValue(BigDecimal.valueOf(49.99));
        newProduct.setCategory(new CategoryOrderResponse(1L, "Category A"));
        newProduct.setImageUrl("http://image.url/b");

        assertThat(newProduct.getId()).isEqualTo(id);
        assertThat(newProduct.getName()).isEqualTo("Product B");
        assertThat(newProduct.getDescription()).isEqualTo("Description of Product B");
        assertThat(newProduct.getValue()).isEqualByComparingTo(BigDecimal.valueOf(49.99));
        assertThat(newProduct.getCategory().getDescription()).isEqualTo("Category A");
        assertThat(newProduct.getImageUrl()).isEqualTo("http://image.url/b");
    }

    @Test
    void testBuilder() {
        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isEqualTo("Product A");
        assertThat(product.getDescription()).isEqualTo("Description of Product A");
        assertThat(product.getValue()).isEqualByComparingTo(BigDecimal.valueOf(29.99));
        assertThat(product.getCategory().getDescription()).isEqualTo("Category A");
        assertThat(product.getImageUrl()).isEqualTo("http://image.url");
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        ProductOrderResponse product1 = ProductOrderResponse.builder()
                .id(id)
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new CategoryOrderResponse(1L, "Category A"))
                .imageUrl("http://image.url")
                .build();

        ProductOrderResponse product2 = ProductOrderResponse.builder()
                .id(id)
                .name("Product A")
                .description("Description of Product A")
                .value(BigDecimal.valueOf(29.99))
                .category(new CategoryOrderResponse(1L, "Category A"))
                .imageUrl("http://image.url")
                .build();

        ProductOrderResponse product3 = ProductOrderResponse.builder()
                .id(UUID.randomUUID())
                .name("Product B")
                .description("Description of Product B")
                .value(BigDecimal.valueOf(49.99))
                .category(new CategoryOrderResponse(1L, "Category A"))
                .imageUrl("http://image.url/b")
                .build();

        assertThat(product1).isEqualTo(product2);
        assertThat(product1).hasSameHashCodeAs(product2);
        assertThat(product1).isNotEqualTo(product3);
        assertThat(product1.hashCode()).isNotEqualTo(product3.hashCode());
    }

    @Test
    void testToString() {
        String toString = product.toString();
        assertThat(toString).contains("name=Product A").contains("description=Description of Product A").contains("value=29.99");
    }
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

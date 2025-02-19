package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CategoryOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.OrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PaymentOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProductOrderResponse;
import br.com.fiap.fiapeats.core.domain.Category;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductDocumentTest {

    @Test
    void testConstructorAndGetters() {
        Category category = new Category(1L, "Categoria 1");
        ProductDocument product = ProductDocument.builder()
                .id("prod1")
                .name("Produto 1")
                .description("Descrição do produto 1")
                .value(new BigDecimal("100.00"))
                .category(category)
                .imageUrl("http://example.com/produto1.jpg")
                .build();

        assertEquals("prod1", product.getId());
        assertEquals("Produto 1", product.getName());
        assertEquals("Descrição do produto 1", product.getDescription());
        assertEquals(new BigDecimal("100.00"), product.getValue());
        assertEquals(category, product.getCategory());
        assertEquals("http://example.com/produto1.jpg", product.getImageUrl());
    }

    @Test
    void testNoArgsConstructor() {
        ProductDocument product = ProductDocument.builder().build();

        assertNull(product.getId());
        assertNull(product.getName());
        assertNull(product.getDescription());
        assertNull(product.getValue());
        assertNull(product.getCategory());
        assertNull(product.getImageUrl());
    }

    @Test
    void testProductDocumentCreationUsingBuilder() {
        Category category = new Category(1L, "Food");
        String productId = "product-123";
        String productName = "Pizza";
        String productDescription = "Delicious pizza";
        BigDecimal productValue = new BigDecimal("19.99");
        String productImageUrl = "http://example.com/image.jpg";

        ProductDocument productDocument = ProductDocument.builder()
                .id(productId)
                .name(productName)
                .description(productDescription)
                .value(productValue)
                .category(category)
                .imageUrl(productImageUrl)
                .build();

        assertEquals(productId, productDocument.getId());
        assertEquals(productName, productDocument.getName());
        assertEquals(productDescription, productDocument.getDescription());
        assertEquals(productValue, productDocument.getValue());
        assertEquals(category, productDocument.getCategory());
        assertEquals(productImageUrl, productDocument.getImageUrl());
    }

    @Test
    void testProductDocumentWithNoData() {
        ProductDocument productDocument = ProductDocument.builder().build();

        assertNull(productDocument.getId());
        assertNull(productDocument.getName());
        assertNull(productDocument.getDescription());
        assertNull(productDocument.getValue());
        assertNull(productDocument.getCategory());
        assertNull(productDocument.getImageUrl());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        UUID productId = UUID.randomUUID();
        String name = "produto";
        BigDecimal value = BigDecimal.TEN;

        Category category = new Category(1L, "Bebida");

        ProductDocument productDocument = ProductDocument.builder()
                .id(productId.toString())
                .name(name)
                .description(name)
                .value(value)
                .category(category)
                .imageUrl("url-image")
                .build();

        ProductDocument productDocument2 = ProductDocument.builder()
                .id(productId.toString())
                .name(name)
                .description(name)
                .value(value)
                .category(category)
                .imageUrl("url-image")
                .build();

        assertEquals(productDocument, productDocument2);
    }

    @Test
    void testToString() {
        Category category = new Category(1L, "Categoria 1");
        ProductDocument product = ProductDocument.builder()
                .id("prod1")
                .name("Produto 1")
                .description("Descrição do produto 1")
                .value(new BigDecimal("100.00"))
                .category(category)
                .imageUrl("http://example.com/produto1.jpg")
                .build();

        String toStringOutput = product.toString();
        assertTrue(toStringOutput.contains("prod1"));
        assertTrue(toStringOutput.contains("Produto 1"));
        assertTrue(toStringOutput.contains("100.00"));
        assertTrue(toStringOutput.contains("Categoria 1"));
        assertTrue(toStringOutput.contains("http://example.com/produto1.jpg"));
    }

}

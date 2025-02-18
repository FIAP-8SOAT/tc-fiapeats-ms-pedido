package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import br.com.fiap.fiapeats.core.domain.Category;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductDocumentTest {

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
}

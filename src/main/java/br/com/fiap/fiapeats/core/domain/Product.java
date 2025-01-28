package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal value;
    private Category category;
    private String imageUrl;

    public Product(UUID id) {
        this.id = id;
    }

    public Product(UUID id, String name, String description, BigDecimal value, Category category, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

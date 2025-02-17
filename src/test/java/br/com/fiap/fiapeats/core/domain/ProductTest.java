package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

  private Product product;
  private UUID id;
  private String name;
  private String description;
  private BigDecimal value;
  private Category category;
  private String imageUrl;

  @BeforeEach
  void setUp() {
    id = UUID.randomUUID();
    name = "Pizza";
    description = "Delicious pizza";
    value = BigDecimal.valueOf(39.99);
    category = new Category(1L, "Food");
    imageUrl = "pizza.jpg";

    product = new Product(id, name, description, value, category, imageUrl);
  }

  @Test
  void shouldCreateProductWithAllFields() {
    assertThat(product.getId()).isEqualTo(id);
    assertThat(product.getName()).isEqualTo(name);
    assertThat(product.getDescription()).isEqualTo(description);
    assertThat(product.getValue()).isEqualTo(value);
    assertThat(product.getCategory()).isEqualTo(category);
    assertThat(product.getImageUrl()).isEqualTo(imageUrl);
  }

  @Test
  void shouldCreateProductWithIdOnly() {
    UUID newId = UUID.randomUUID();
    Product productWithIdOnly = new Product(newId);
    assertThat(productWithIdOnly.getId()).isEqualTo(newId);
    assertThat(productWithIdOnly.getName()).isNull();
    assertThat(productWithIdOnly.getDescription()).isNull();
    assertThat(productWithIdOnly.getValue()).isNull();
    assertThat(productWithIdOnly.getCategory()).isNull();
    assertThat(productWithIdOnly.getImageUrl()).isNull();
  }

  @Test
  void shouldUpdateId() {
    UUID newId = UUID.randomUUID();
    product.setId(newId);
    assertThat(product.getId()).isEqualTo(newId);
  }

  @Test
  void shouldUpdateName() {
    String newName = "Burger";
    product.setName(newName);
    assertThat(product.getName()).isEqualTo(newName);
  }

  @Test
  void shouldUpdateDescription() {
    String newDescription = "Juicy burger";
    product.setDescription(newDescription);
    assertThat(product.getDescription()).isEqualTo(newDescription);
  }

  @Test
  void shouldUpdateValue() {
    BigDecimal newValue = BigDecimal.valueOf(19.99);
    product.setValue(newValue);
    assertThat(product.getValue()).isEqualTo(newValue);
  }

  @Test
  void shouldUpdateCategory() {
    Category newCategory = new Category(1L, "Drinks");
    product.setCategory(newCategory);
    assertThat(product.getCategory()).isEqualTo(newCategory);
  }

  @Test
  void shouldUpdateImageUrl() {
    String newImageUrl = "burger.jpg";
    product.setImageUrl(newImageUrl);
    assertThat(product.getImageUrl()).isEqualTo(newImageUrl);
  }

  @Test
  void shouldHaveCorrectToString() {
    String result = product.toString();
    assertThat(result)
        .contains(
            "id=" + id,
            "name='" + name + "'",
            "description='" + description + "'",
            "value=" + value,
            "category=" + category.toString(),
            "imageUrl='" + imageUrl + "'");
  }
}

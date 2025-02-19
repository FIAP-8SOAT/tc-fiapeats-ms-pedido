package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CategoryTest {

  @Test
  void shouldCreateCategoryWithIdAndDescription() {
    Long id = 1L;
    String description = "Drinks";
    Category category = new Category(id, description);
    assertThat(category.getId()).isEqualTo(id);
    assertThat(category.getDescription()).isEqualTo(description);
  }

  @Test
  void shouldUpdateCategoryId() {
    Category category = new Category(1L, "Drinks");
    Long newId = 2L;
    category.setId(newId);
    assertThat(category.getId()).isEqualTo(newId);
  }

  @Test
  void shouldUpdateCategoryDescription() {
    Category category = new Category(1L, "Drinks");
    String newDescription = "Food";
    category.setDescription(newDescription);
    assertThat(category.getDescription()).isEqualTo(newDescription);
  }

  @Test
  void shouldHaveCorrectToString() {
    Category category = new Category(1L, "Drinks");
    String result = category.toString();
    assertThat(result).contains("id=1", "description='Drinks'");
  }
}

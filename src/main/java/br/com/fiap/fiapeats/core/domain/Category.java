package br.com.fiap.fiapeats.core.domain;

import java.io.Serializable;

public class Category implements Serializable {
  private Long id;
  private String description;

  public Category(Long id, String description) {
    this.id = id;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Category{" + "id=" + id + ", description='" + description + '\'' + '}';
  }
}

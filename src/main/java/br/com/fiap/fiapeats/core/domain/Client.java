package br.com.fiap.fiapeats.core.domain;

public class Client {
  private String name;
  private String email;
  private String document;

  public Client(String name, String email, String document) {
    this.name = name;
    this.email = email;
    this.document = document;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }
}

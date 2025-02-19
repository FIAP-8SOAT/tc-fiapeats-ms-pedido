package br.com.fiap.fiapeats.core.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}

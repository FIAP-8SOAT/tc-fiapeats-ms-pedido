package br.com.fiap.fiapeats.core.exceptions;

public class ClientNotFoundException extends RuntimeException {
  public ClientNotFoundException(String message) {
    super(message);
  }
}

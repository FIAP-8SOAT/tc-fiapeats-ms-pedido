package br.com.fiap.fiapeats.core.utils;

public class Constants {
  private Constants() {
    throw new UnsupportedOperationException(
        "Esta classe é uma classe utilitária e não pode ser instanciada");
  }

  public static final String CORRELATION_ID = "correlation_id";
  public static final String PENDING = "Pendente";
  public static final String TXT_PRODUCT_NOT_FOUND =
      "Existem produtos na lista que não estão na base";
  public static final String TXT_CLIENT_NOT_FOUND = "O cliente informado não consta cadastro";
  public static final String TXT_FEIGN_REQUEST_ERROR = "Erro ao realizar request!";
}

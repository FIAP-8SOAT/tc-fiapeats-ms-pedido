package br.com.fiap.fiapeats.core.domain;

import java.util.List;

public class PaymentGenerateQrCode {
  private String orderId;
  private List<Product> products;

  public PaymentGenerateQrCode(String orderId, List<Product> products) {
    this.orderId = orderId;
    this.products = products;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}

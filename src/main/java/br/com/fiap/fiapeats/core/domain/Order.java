package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

  private UUID id;
  private List<Product> products;
  private String taxId;
  private BigDecimal value;
  private String qrCode;
  private String orderStatus;
  private String paymentStatus;
  private LocalDateTime createTimestamp;
  private int timeWaiting;

  public Order(
      UUID id,
      List<Product> products,
      String taxId,
      BigDecimal value,
      String orderStatus,
      String paymentStatus,
      LocalDateTime createTimestamp,
      int timeWaiting,
      String qrCode) {
    this.id = id;
    this.products = products;
    this.taxId = taxId;
    this.value = value;
    this.orderStatus = orderStatus;
    this.paymentStatus = paymentStatus;
    this.createTimestamp = createTimestamp;
    this.timeWaiting = timeWaiting;
    this.qrCode = qrCode;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public String getTaxId() {
    return taxId;
  }

  public void setTaxId(String taxId) {
    this.taxId = taxId;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public LocalDateTime getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(LocalDateTime createTimestamp) {
    this.createTimestamp = createTimestamp;
  }

  public int getTimeWaiting() {
    return timeWaiting;
  }

  public void setTimeWaiting(int timeWaiting) {
    this.timeWaiting = timeWaiting;
  }

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", products=" + (products != null ? products.toString() : "[]") +
            ", taxId='" + taxId + '\'' +
            ", value=" + value +
            ", qrCode='" + qrCode + '\'' +
            ", orderStatus='" + orderStatus + '\'' +
            ", paymentStatus='" + paymentStatus + '\'' +
            ", createTimestamp=" + createTimestamp +
            ", timeWaiting=" + timeWaiting +
            '}';
  }

}

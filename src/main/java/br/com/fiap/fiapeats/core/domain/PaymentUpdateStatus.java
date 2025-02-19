package br.com.fiap.fiapeats.core.domain;

public class PaymentUpdateStatus {
  private String orderId;
  private Long paymentId;
  private String paymentStatus;

  public PaymentUpdateStatus(String orderId, Long paymentId, String paymentStatus) {
    this.orderId = orderId;
    this.paymentId = paymentId;
    this.paymentStatus = paymentStatus;
  }

  public PaymentUpdateStatus() {}

  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  @Override
  public String toString() {
    return "PaymentUpdateStatus{"
        + "orderId='"
        + orderId
        + '\''
        + ", paymentId="
        + paymentId
        + ", paymentStatus='"
        + paymentStatus
        + '\''
        + '}';
  }
}

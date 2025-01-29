package br.com.fiap.fiapeats.core.domain;

public class Payment {
  private String orderId;
  private String notificationUrl;

  public Payment(String orderId, String notificationUrl) {
    this.orderId = orderId;
    this.notificationUrl = notificationUrl;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getNotificationUrl() {
    return notificationUrl;
  }

  public void setNotificationUrl(String notificationUrl) {
    this.notificationUrl = notificationUrl;
  }
}

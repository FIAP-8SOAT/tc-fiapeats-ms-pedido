package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentGenerateQrCodeTest {

  private PaymentGenerateQrCode paymentGenerateQrCode;
  private String orderId;
  private String notificationUrl;

  @BeforeEach
  void setUp() {
    orderId = "12345";
    notificationUrl = "https://example.com/notify";
    paymentGenerateQrCode = new PaymentGenerateQrCode(orderId, notificationUrl);
  }

  @Test
  void shouldCreatePaymentGenerateQrCodeWithAllFields() {
    assertThat(paymentGenerateQrCode.getOrderId()).isEqualTo(orderId);
    assertThat(paymentGenerateQrCode.getNotificationUrl()).isEqualTo(notificationUrl);
  }

  @Test
  void shouldUpdateOrderId() {
    String newOrderId = "67890";
    paymentGenerateQrCode.setOrderId(newOrderId);
    assertThat(paymentGenerateQrCode.getOrderId()).isEqualTo(newOrderId);
  }

  @Test
  void shouldUpdateNotificationUrl() {
    String newNotificationUrl = "https://example.com/updated-notify";
    paymentGenerateQrCode.setNotificationUrl(newNotificationUrl);
    assertThat(paymentGenerateQrCode.getNotificationUrl()).isEqualTo(newNotificationUrl);
  }

  @Test
  void shouldHaveCorrectToString() {
    String result = paymentGenerateQrCode.toString();
    assertThat(result)
        .contains("orderId='" + orderId + "'", "notificationUrl='" + notificationUrl + "'");
  }
}

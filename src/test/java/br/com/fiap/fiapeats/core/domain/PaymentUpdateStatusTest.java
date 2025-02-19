package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentUpdateStatusTest {

  private PaymentUpdateStatus paymentUpdateStatus;
  private String orderId;
  private Long paymentId;
  private String paymentStatus;

  @BeforeEach
  void setUp() {
    orderId = "12345";
    paymentId = 1001L;
    paymentStatus = "PAID";
    paymentUpdateStatus = new PaymentUpdateStatus(orderId, paymentId, paymentStatus);
  }

  @Test
  void shouldCreatePaymentUpdateStatusWithAllFields() {
    assertThat(paymentUpdateStatus.getOrderId()).isEqualTo(orderId);
    assertThat(paymentUpdateStatus.getPaymentId()).isEqualTo(paymentId);
    assertThat(paymentUpdateStatus.getPaymentStatus()).isEqualTo(paymentStatus);
  }

  @Test
  void shouldUpdateOrderId() {
    String newOrderId = "67890";
    paymentUpdateStatus.setOrderId(newOrderId);
    assertThat(paymentUpdateStatus.getOrderId()).isEqualTo(newOrderId);
  }

  @Test
  void shouldUpdatePaymentId() {
    Long newPaymentId = 2002L;
    paymentUpdateStatus.setPaymentId(newPaymentId);
    assertThat(paymentUpdateStatus.getPaymentId()).isEqualTo(newPaymentId);
  }

  @Test
  void shouldUpdatePaymentStatus() {
    String newPaymentStatus = "PENDING";
    paymentUpdateStatus.setPaymentStatus(newPaymentStatus);
    assertThat(paymentUpdateStatus.getPaymentStatus()).isEqualTo(newPaymentStatus);
  }

  @Test
  void shouldHaveCorrectToString() {
    String result = paymentUpdateStatus.toString();
    assertThat(result)
        .contains(
            "orderId='" + orderId + "'",
            "paymentId=" + paymentId,
            "paymentStatus='" + paymentStatus + "'");
  }
}

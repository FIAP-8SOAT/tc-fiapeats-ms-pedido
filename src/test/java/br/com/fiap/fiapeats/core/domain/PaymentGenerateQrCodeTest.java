package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

class PaymentGenerateQrCodeTest {

  private PaymentGenerateQrCode paymentGenerateQrCode;
  private String orderId;
  private Product product;

  @BeforeEach
  void setUp() {
    orderId = "12345";
    product = new Product(UUID.randomUUID(), "produto", "produto", BigDecimal.TEN, new Category(1L, "Bebida"), null);
    paymentGenerateQrCode = new PaymentGenerateQrCode(orderId, List.of(product));
  }

  @Test
  void shouldCreatePaymentGenerateQrCodeWithAllFields() {
    assertThat(paymentGenerateQrCode.getOrderId()).isEqualTo(orderId);
  }

  @Test
  void shouldUpdateOrderId() {
    String newOrderId = "67890";
    paymentGenerateQrCode.setOrderId(newOrderId);
    assertThat(paymentGenerateQrCode.getOrderId()).isEqualTo(newOrderId);
  }
}

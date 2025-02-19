package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.PaymentGenerateQrCode;

public interface FeignCreatePaymentPort {
  String createPayment(PaymentGenerateQrCode paymentGenerateQrCode);
}

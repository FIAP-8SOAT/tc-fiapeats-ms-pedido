package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;

public interface ProcessPaymentPort {
  void updatePayment(PaymentUpdateStatus paymentUpdateStatus);
}

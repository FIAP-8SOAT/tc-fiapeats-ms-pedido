package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.ports.in.ProcessPaymentPort;
import br.com.fiap.fiapeats.core.ports.out.PaymentUpdatePort;

public class ProcessPaymentImpl implements ProcessPaymentPort {

  private PaymentUpdatePort paymentUpdatePort;

  private OrderMapper orderMapper;

  public ProcessPaymentImpl(PaymentUpdatePort paymentUpdatePort, OrderMapper orderMapper) {
    this.paymentUpdatePort = paymentUpdatePort;
    this.orderMapper = orderMapper;
  }

  @Override
  public void updatePayment(PaymentUpdateStatus paymentUpdateStatus) {
    if (paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId()).isPresent()) {
      Order newDoc =
          orderMapper.toOrderFromOrderDocument(
              paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId()).get());
      newDoc.setPaymentId(paymentUpdateStatus.getPaymentId());
      newDoc.setPaymentStatus(paymentUpdateStatus.getPaymentStatus());
      paymentUpdatePort.update(orderMapper.toOrderDocumentFromOrder(newDoc));
    } else {
      throw new OrderNotFoundException(
          "Ordem " + paymentUpdateStatus.getOrderId() + " não existe na base");
    }
  }
}

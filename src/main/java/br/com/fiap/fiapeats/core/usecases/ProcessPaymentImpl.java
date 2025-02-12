package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.ports.in.ProcessPaymentPort;
import br.com.fiap.fiapeats.core.ports.out.PaymentUpdatePort;
import java.util.Optional;

public class ProcessPaymentImpl implements ProcessPaymentPort {

  private PaymentUpdatePort paymentUpdatePort;

  private OrderMapper orderMapper;

  public ProcessPaymentImpl(PaymentUpdatePort paymentUpdatePort, OrderMapper orderMapper) {
    this.paymentUpdatePort = paymentUpdatePort;
    this.orderMapper = orderMapper;
  }

  @Override
  public void updatePayment(PaymentUpdateStatus paymentUpdateStatus) {
    Optional<OrderDocument> optionalOrder =
        paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId());

    if (optionalOrder.isPresent()) {
      Order newDoc = orderMapper.toOrderFromOrderDocument(optionalOrder.get());
      newDoc.setPaymentId(paymentUpdateStatus.getPaymentId());
      newDoc.setPaymentStatus(paymentUpdateStatus.getPaymentStatus());
      paymentUpdatePort.update(orderMapper.toOrderDocumentFromOrder(newDoc));
    } else {
      throw new OrderNotFoundException(
          String.format("Ordem %s não existe na base", paymentUpdateStatus.getOrderId()));
    }
  }
}

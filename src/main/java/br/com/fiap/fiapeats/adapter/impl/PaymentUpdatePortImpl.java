package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.OrderRepository;
import br.com.fiap.fiapeats.core.ports.out.PaymentUpdatePort;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PaymentUpdatePortImpl implements PaymentUpdatePort {
  private final OrderRepository orderRepository;

  public PaymentUpdatePortImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public void update(OrderDocument orderDocument) {
    orderRepository.save(orderDocument);
  }

  @Override
  public Optional<OrderDocument> getOrder(String orderId) {
    return orderRepository.findById(orderId);
  }
}

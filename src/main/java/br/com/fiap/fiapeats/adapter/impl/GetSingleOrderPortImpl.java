package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.OrderRepository;
import br.com.fiap.fiapeats.core.ports.out.GetSingleOrderPort;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetSingleOrderPortImpl implements GetSingleOrderPort {
  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  public GetSingleOrderPortImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
    this.orderRepository = orderRepository;
    this.orderMapper = orderMapper;
  }

  @Override
  public Optional<OrderDocument> getOrderById(String orderId) {
    return orderRepository.findById(orderId);
  }
}

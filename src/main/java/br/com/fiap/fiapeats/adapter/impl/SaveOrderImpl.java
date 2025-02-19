package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.OrderRepository;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import org.springframework.stereotype.Service;

@Service
public class SaveOrderImpl implements SaveOrderPort {

  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  public SaveOrderImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
    this.orderRepository = orderRepository;
    this.orderMapper = orderMapper;
  }

  @Override
  public void save(Order order) {
    orderRepository.save(orderMapper.toOrderDocumentFromOrder(order));
  }
}

package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Order;

public interface CreateOrderPort {

  void create(Order order);
}

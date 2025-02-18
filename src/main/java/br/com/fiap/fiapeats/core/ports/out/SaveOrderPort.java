package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Order;

public interface SaveOrderPort {
  void save(Order order);
}

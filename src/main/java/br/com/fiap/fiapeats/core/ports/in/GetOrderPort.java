package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.core.domain.Order;

public interface GetOrderPort {
  Order getOrderById(String orderId);

  Order getOrderByParameters(GetOrderHeaderRequest request);
}

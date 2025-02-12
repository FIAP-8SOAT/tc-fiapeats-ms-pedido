package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.core.domain.Order;

public interface GetOrderPort {
  public Order getOrderById(String orderId);

  public void getOrderByParameters(GetOrderHeaderRequest request);
}

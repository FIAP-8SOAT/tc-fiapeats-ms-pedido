package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.ports.in.GetOrderPort;
import br.com.fiap.fiapeats.core.ports.out.GetListOrderPort;
import br.com.fiap.fiapeats.core.ports.out.GetSingleOrderPort;

public class GetOrderImpl implements GetOrderPort {

  private final GetSingleOrderPort getSingleOrderPort;
  private final GetListOrderPort getListOrderPort;
  private final OrderMapper orderMapper;

  public GetOrderImpl(
      GetSingleOrderPort getSingleOrderPort,
      GetListOrderPort getListOrderPort,
      OrderMapper orderMapper) {
    this.getSingleOrderPort = getSingleOrderPort;
    this.getListOrderPort = getListOrderPort;
    this.orderMapper = orderMapper;
  }

  @Override
  public Order getOrderById(String orderId) {
    return getSingleOrderPort
        .getOrderById(orderId)
        .map(orderMapper::toOrderFromOrderDocument)
        .orElseThrow(
            () -> new OrderNotFoundException(String.format("Ordem %s não encontrada", orderId)));
  }

  @Override
  public void getOrderByParameters(GetOrderHeaderRequest request) {
    getListOrderPort.getOrderByHeaders(request);
  }
}

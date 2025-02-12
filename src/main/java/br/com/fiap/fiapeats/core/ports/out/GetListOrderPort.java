package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;

public interface GetListOrderPort {
  void getOrderByHeaders(GetOrderHeaderRequest request);
}

package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;

public interface GetListOrderPort {
  OrderDocument getOrderByHeaders(GetOrderHeaderRequest request);
}

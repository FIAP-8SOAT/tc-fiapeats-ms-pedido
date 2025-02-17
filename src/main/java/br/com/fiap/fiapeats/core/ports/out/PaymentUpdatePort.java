package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import java.util.Optional;

public interface PaymentUpdatePort {
  void update(OrderDocument orderDocument);

  Optional<OrderDocument> getOrder(String orderId);
}

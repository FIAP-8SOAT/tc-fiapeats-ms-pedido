package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.exceptions.ClientNotFoundException;
import br.com.fiap.fiapeats.core.exceptions.FillOrderPropertiesException;
import br.com.fiap.fiapeats.core.exceptions.ProductNotFoundException;

public interface ProcessOrderPort {
  Order process(Order order)
      throws FillOrderPropertiesException, ClientNotFoundException, ProductNotFoundException;
}

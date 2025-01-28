package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.ports.in.CreateOrderPort;

public class CreateOrderImpl implements CreateOrderPort {


    @Override
    public String create(Order order) {
        String name = order.getProducts().get(0).getName();
        return "valido";
    }
}

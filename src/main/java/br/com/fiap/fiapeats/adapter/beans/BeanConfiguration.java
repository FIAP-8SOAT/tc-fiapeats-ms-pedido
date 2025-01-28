package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.core.ports.in.CreateOrderPort;
import br.com.fiap.fiapeats.core.usecases.CreateOrderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateOrderPort createOrderPort(){
        return new CreateOrderImpl();
    }
}

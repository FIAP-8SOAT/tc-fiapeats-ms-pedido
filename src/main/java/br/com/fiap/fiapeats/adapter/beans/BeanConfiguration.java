package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.adapter.impl.FeignCreatePaymentPortImpl;
import br.com.fiap.fiapeats.adapter.impl.FeignFindClientPortImpl;
import br.com.fiap.fiapeats.adapter.mapper.FeignClientMapper;
import br.com.fiap.fiapeats.adapter.mapper.FeignPaymentMapper;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignCreatePayment;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindClient;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.ports.in.ProcessPaymentPort;
import br.com.fiap.fiapeats.core.ports.out.*;
import br.com.fiap.fiapeats.core.usecases.ProcessOrderImpl;
import br.com.fiap.fiapeats.core.usecases.ProcessPaymentImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public ProcessOrderPort processOrderPort(
      FeignFindProductsPort feignFindProductsPort,
      SaveOrderPort saveOrderPort,
      FeignFindClientPort feignFindClientPort,
      FeignCreatePaymentPort feignCreatePaymentPort) {
    return new ProcessOrderImpl(
        feignFindProductsPort, saveOrderPort, feignFindClientPort, feignCreatePaymentPort);
  }

  @Bean
  public FeignFindClientPort feignFindClientPort(
      FeignFindClient feignFindClient, FeignClientMapper feignClientMapper) {
    return new FeignFindClientPortImpl(feignFindClient, feignClientMapper);
  }

  @Bean
  public FeignCreatePaymentPort feignCreatePaymentPort(
      FeignCreatePayment feignCreatePayment, FeignPaymentMapper feignPaymentMapper) {
    return new FeignCreatePaymentPortImpl(feignCreatePayment, feignPaymentMapper);
  }

  @Bean
  public ProcessPaymentPort processPaymentPort(
      PaymentUpdatePort paymentUpdatePort, OrderMapper orderMapper) {
    return new ProcessPaymentImpl(paymentUpdatePort, orderMapper);
  }
}

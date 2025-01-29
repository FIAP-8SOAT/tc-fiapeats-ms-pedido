package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.adapter.impl.FeignFindClientPortImpl;
import br.com.fiap.fiapeats.adapter.mapper.FeignClientMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindClient;
import br.com.fiap.fiapeats.core.ports.in.CreateOrderPort;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindClientPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import br.com.fiap.fiapeats.core.usecases.CreateOrderImpl;
import br.com.fiap.fiapeats.core.usecases.ProcessOrderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public CreateOrderPort createOrderPort() {
    return new CreateOrderImpl();
  }

  @Bean
  public ProcessOrderPort processOrderPort(
      FeignFindProductsPort feignFindProductsPort,
      SaveOrderPort saveOrderPort,
      FeignFindClientPort feignFindClientPort) {
    return new ProcessOrderImpl(feignFindProductsPort, saveOrderPort, feignFindClientPort);
  }

  @Bean
  public FeignFindClientPort feignFindClientPort(
      FeignFindClient feignFindClient, FeignClientMapper feignClientMapper) {
    return new FeignFindClientPortImpl(feignFindClient, feignClientMapper);
  }
}

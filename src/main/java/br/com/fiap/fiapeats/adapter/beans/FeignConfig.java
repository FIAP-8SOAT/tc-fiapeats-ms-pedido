package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.adapter.out.feign.FeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
  @Bean
  public ErrorDecoder errorDecoder() {
    return new FeignErrorDecoder();
  }
}

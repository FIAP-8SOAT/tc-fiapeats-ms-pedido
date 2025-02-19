package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "FindClient", url = "${feign.client.ms-cliente}")
public interface FeignFindClient {

  @GetMapping("/cliente/{document}")
  FeignClientResponse getClient(
      @PathVariable("document") String document,
      @RequestHeader("correlationId") String correlationId);
}

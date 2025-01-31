package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "FindClient",
    url = "${feign.client.url}",
    configuration = FeignErrorDecoder.class)
public interface FeignFindClient {

  @GetMapping("/cliente/{document}")
  FeignClientResponse getClient(@PathVariable("document") String document);
}

package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "FindProducts", url = "${feign.client.ms-produto}")
public interface FeignFindProducts {

  @GetMapping("/produto")
  List<FeignFindProductsResponse> getAllProducts(
      @RequestHeader("correlationId") String correlationId);
}

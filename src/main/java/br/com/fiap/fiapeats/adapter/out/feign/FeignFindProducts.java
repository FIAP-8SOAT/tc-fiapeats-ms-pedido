package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "FindProducts",
    url = "http://localhost:8080/fiapeats",
    configuration = FeignErrorDecoder.class)
public interface FeignFindProducts {

  @GetMapping("/produto")
  List<FeignFindProductsResponse> getAllProducts();
}

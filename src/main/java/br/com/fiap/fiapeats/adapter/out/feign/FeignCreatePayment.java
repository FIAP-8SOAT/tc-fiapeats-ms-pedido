package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignCreatePaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "FeignCreatePayment", url = "${feign.client.url}")
public interface FeignCreatePayment {
  @PostMapping("/pagamento")
  FeignCreatePaymentResponse createPayment(@RequestBody FeignCreatePaymentRequest request,
                                           @RequestHeader("correlationId") String correlationId);
}

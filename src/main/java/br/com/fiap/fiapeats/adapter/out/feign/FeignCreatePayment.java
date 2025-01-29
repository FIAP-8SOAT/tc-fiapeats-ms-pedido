package br.com.fiap.fiapeats.adapter.out.feign;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignCreatePaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "FeignCreatePayment", url = "http://localhost:8080/fiapeats")
public interface FeignCreatePayment {
  @PostMapping("/pagamento")
  FeignCreatePaymentResponse createPayment(@RequestBody FeignCreatePaymentRequest request);
}

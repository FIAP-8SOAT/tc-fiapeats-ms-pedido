package br.com.fiap.fiapeats.adapter.out.feign.contracts.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignCreatePaymentRequest {
  @JsonProperty("idPedido")
  private String orderId;

  @JsonProperty("produtos")
  private List<FeignProducItemPaymentRequest> products;
}

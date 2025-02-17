package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class PaymentOrderResponse {

  @JsonProperty("statusPagamento")
  private String paymentStatus;

  @JsonProperty("idPagamento")
  private Long paymentId;

  @JsonProperty("qrCode")
  private String qrCode;
}

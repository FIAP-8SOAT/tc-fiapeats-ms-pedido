package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class OrderResponse {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("produtos")
  private List<ProductOrderResponse> products;

  @JsonProperty("cpf")
  private String taxId;

  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("statusOrdem")
  private String orderStatus;

  @JsonProperty("pagamento")
  private PaymentOrderResponse payment;

  @JsonProperty("dataCriacao")
  private LocalDateTime createTimestamp;

  @JsonProperty("tempoEspera")
  private int timeWaiting;
}

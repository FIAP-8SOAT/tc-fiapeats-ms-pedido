package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateOrderResponse {
  @JsonProperty("idPedido")
  private String orderId;

  @JsonProperty("cliCpf")
  private String taxId;

  @JsonProperty("status")
  private String status;

  @JsonProperty("tempoEspera")
  private int timeWaiting;

  @JsonProperty("dataHoraCriacao")
  private LocalDateTime createTimestamp;

  @JsonProperty("QrCodePagamento")
  private String qrCode;
}

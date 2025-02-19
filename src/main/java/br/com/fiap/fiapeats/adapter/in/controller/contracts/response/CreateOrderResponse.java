package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Generated("lombok")
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

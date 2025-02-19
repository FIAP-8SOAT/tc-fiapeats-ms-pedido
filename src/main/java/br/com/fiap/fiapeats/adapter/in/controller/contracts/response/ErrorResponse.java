package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ErrorResponse {

  private final LocalDateTime timestamp = LocalDateTime.now();

  @JsonProperty("Erro")
  private final String errorName;

  @JsonProperty("codigo")
  private final int errorCode;

  @JsonProperty("mensagem")
  private final String message;
}

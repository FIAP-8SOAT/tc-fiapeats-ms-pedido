package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderHeaderRequest {

  private String produtoId;
  private String produtoNome;
  private String produtoDescricao;
  private String produtoValor;
  private Long categoriaId;
  private String categoriaDescricao;
  private String cpf;
  private String valor;
  private String statusOrdem;
  private String pagamentoStatus;
  private Long pagamentoId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dataCriacao;

  private int tempoEspera;
}

package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

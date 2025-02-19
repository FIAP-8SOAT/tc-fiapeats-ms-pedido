package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ProductOrderResponse {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("nome")
  private String name;

  @JsonProperty("descricao")
  private String description;

  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("categoria")
  private CategoryOrderResponse category;

  @JsonProperty("urlImagem")
  private String imageUrl;
}

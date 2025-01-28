package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignFindProductsResponse {
  private UUID id;

  @JsonProperty("nome")
  private String name;

  @JsonProperty("descricao")
  private String description;

  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("categoria")
  private String category;

  @JsonProperty("imagemUrl")
  private String imageUrl;
}

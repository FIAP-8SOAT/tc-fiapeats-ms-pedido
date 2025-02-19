package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import jakarta.annotation.Generated;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated("lombok")
public class FeignFindProductsResponse {
  private String id;

  @JsonProperty("nome")
  private String name;

  @JsonProperty("descricao")
  private String description;

  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("categoria")
  private FeignFindProductsCategoryResponse category;

  @JsonProperty("imagemUrl")
  private String imageUrl;
}

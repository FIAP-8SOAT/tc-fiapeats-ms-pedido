package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignClientResponse {

  @JsonProperty("nome")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("documento")
  private String document;
}

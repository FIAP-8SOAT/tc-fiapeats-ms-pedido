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
public class FeignFindProductsCategoryResponse {

    private String id;

    @JsonProperty("descricao")
    private String description;
}

package br.com.fiap.fiapeats.adapter.out.feign.contracts.request;

import br.com.fiap.fiapeats.core.domain.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignProducItemPaymentRequest {


    private UUID id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("categoriaDescricao")
    private String category;
}

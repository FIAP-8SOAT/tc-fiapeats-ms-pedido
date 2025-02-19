package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.Generated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateOrderRequest {
  @Size(min = 1, message = "a lista deve conter pelo menos 1 produto")
  @ArraySchema(
      arraySchema =
          @Schema(
              description = "Lista de ID's de produtos a serem incluídos no pedido",
              example =
                  "[\"fc7c7f37-32ea-465c-ac4b-490685e5a55f\", \"fa0f9dde-b305-407b-869c-71045853dea8\"]",
              requiredMode = Schema.RequiredMode.REQUIRED),
      uniqueItems = true)
  @JsonProperty("idProdutos")
  private List<UUID> idProducts;

  @Size(min = 11, max = 11, message = "Deve conter exatamente 11 dígitos")
  @Pattern(regexp = "^[0-9]*$", message = "Aceita apenas números")
  @Schema(
      description = "numero do documento",
      example = "76590487654",
      requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cliCpf")
  private String taxId;

  @Positive(message = "Deve ser maior que 0")
  @NotNull(message = "Não pode ser nulo")
  @Schema(
      description = "Valor do pedido",
      example = "86.15",
      requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("valor")
  private BigDecimal value;
}

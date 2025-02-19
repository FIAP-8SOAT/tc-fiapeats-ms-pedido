package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentUpdateRequest {
  private Long paymentId;
  private String paymentStatus;
}

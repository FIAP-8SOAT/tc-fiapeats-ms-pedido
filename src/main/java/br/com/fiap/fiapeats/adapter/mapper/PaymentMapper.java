package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PaymentUpdateRequest;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

  PaymentUpdateStatus toPaymentUpdateStatusFromPaymentUpdateRequest(
      PaymentUpdateRequest paymentUpdateRequest, String orderId);
}

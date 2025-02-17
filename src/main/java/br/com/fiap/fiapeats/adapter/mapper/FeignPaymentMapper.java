package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.core.domain.PaymentGenerateQrCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeignPaymentMapper {
  FeignCreatePaymentRequest toFeignPaymentRequestFromPaymentGenerateQrCode(
      PaymentGenerateQrCode paymentGenerateQrCode);
}

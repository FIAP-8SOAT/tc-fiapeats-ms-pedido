package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignProducItemPaymentRequest;
import br.com.fiap.fiapeats.core.domain.PaymentGenerateQrCode;
import br.com.fiap.fiapeats.core.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeignPaymentMapper {
  FeignCreatePaymentRequest toFeignPaymentRequestFromPaymentGenerateQrCode(
      PaymentGenerateQrCode paymentGenerateQrCode);

  @Mapping(source = "category.description", target = "category")
  FeignProducItemPaymentRequest toFeignProductItemFromProduct(Product product);
}

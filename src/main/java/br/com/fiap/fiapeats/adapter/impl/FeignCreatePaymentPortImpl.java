package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.FeignPaymentMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignCreatePayment;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignCreatePaymentResponse;
import br.com.fiap.fiapeats.core.domain.Payment;
import br.com.fiap.fiapeats.core.ports.out.FeignCreatePaymentPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import org.apache.logging.log4j.ThreadContext;

public class FeignCreatePaymentPortImpl implements FeignCreatePaymentPort {

  private final FeignCreatePayment feignCreatePayment;
  private final FeignPaymentMapper feignPaymentMapper;

  public FeignCreatePaymentPortImpl(
      FeignCreatePayment feignCreatePayment, FeignPaymentMapper feignPaymentMapper) {
    this.feignCreatePayment = feignCreatePayment;
    this.feignPaymentMapper = feignPaymentMapper;
  }

  @Override
  public String createPayment(Payment payment) {
    FeignCreatePaymentResponse response =
        feignCreatePayment.createPayment(
            feignPaymentMapper.toFeignPaymentRequestFromPayment(payment), ThreadContext.get(Constants.CORRELATION_ID));
    return response.getQrCode();
  }
}

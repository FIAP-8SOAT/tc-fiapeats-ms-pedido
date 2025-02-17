package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.*;
import br.com.fiap.fiapeats.adapter.mapper.FeignPaymentMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignCreatePayment;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignCreatePaymentResponse;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.PaymentGenerateQrCode;
import br.com.fiap.fiapeats.core.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FeignCreatePaymentPortImplTest {

    @InjectMocks
    private FeignCreatePaymentPortImpl feignCreatePaymentPort;
    @Mock
    private FeignCreatePayment feignCreatePayment;
    @Mock
    private FeignPaymentMapper feignPaymentMapper;
    private PaymentGenerateQrCode paymentGenerateQrCode;
    private FeignCreatePaymentRequest feignCreatePaymentRequest;
    private FeignCreatePaymentResponse feignCreatePaymentResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentGenerateQrCode = new PaymentGenerateQrCode("123456", "http://url_notificacao");
        feignCreatePaymentRequest = new FeignCreatePaymentRequest("123456", "http://url_notificacao");
        feignCreatePaymentResponse = new FeignCreatePaymentResponse("codigoQR");
    }

    @Test
    void shouldCreateNewOrderWithSuccess() {

        when(feignPaymentMapper.toFeignPaymentRequestFromPaymentGenerateQrCode(any())).thenReturn(feignCreatePaymentRequest);
        when(feignCreatePayment.createPayment(any(), any())).thenReturn(feignCreatePaymentResponse);

        var response = feignCreatePaymentPort.createPayment(paymentGenerateQrCode);

        assertNotNull(response);
        assertEquals("codigoQR", response);

        verify(feignPaymentMapper, times(1)).toFeignPaymentRequestFromPaymentGenerateQrCode(any());
        verify(feignCreatePayment, times(1)).createPayment(any(), any());
    }
}

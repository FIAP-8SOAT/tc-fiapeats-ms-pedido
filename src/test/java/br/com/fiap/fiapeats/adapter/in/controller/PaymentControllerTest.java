package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PaymentUpdateRequest;
import br.com.fiap.fiapeats.adapter.mapper.PaymentMapper;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import br.com.fiap.fiapeats.core.ports.in.ProcessPaymentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;
    @Mock
    private PaymentMapper paymentMapper;
    @Mock
    private ProcessPaymentPort processPaymentPort;
    private PaymentUpdateRequest paymentUpdateRequest;
    private PaymentUpdateStatus paymentUpdateStatus;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentUpdateRequest = new PaymentUpdateRequest(2L, "Aprovado");
        paymentUpdateStatus = new PaymentUpdateStatus(UUID.randomUUID().toString(), 2L, "Aprovado");
    }

    @Test
    void shouldUpdatePaymentStatusWithSuccess() throws Exception {

        when(paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(paymentUpdateRequest, "123456")).thenReturn(paymentUpdateStatus);

        paymentController.updatePaymentStatus(paymentUpdateRequest, "123456");

        verify(paymentMapper, times(1)).toPaymentUpdateStatusFromPaymentUpdateRequest(any(), any());
        verify(processPaymentPort, times(1)).updatePayment(any());
    }
}

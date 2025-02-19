package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentUpdateRequestTest {

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        Long id = 1L;
        String status = "Pendente";

        PaymentUpdateRequest paymentUpdateRequest = PaymentUpdateRequest.builder().build();
        paymentUpdateRequest.setPaymentId(id);
        paymentUpdateRequest.setPaymentStatus(status);

        PaymentUpdateRequest paymentUpdateRequest2 = PaymentUpdateRequest.builder().build();
        paymentUpdateRequest2.setPaymentId(id);
        paymentUpdateRequest2.setPaymentStatus(status);

        assertEquals(paymentUpdateRequest, paymentUpdateRequest2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        Long id = 1L;
        String status = "Pendente";

        PaymentUpdateRequest paymentUpdateRequest = new PaymentUpdateRequest();
        paymentUpdateRequest.setPaymentId(id);
        paymentUpdateRequest.setPaymentStatus(status);

        PaymentUpdateRequest paymentUpdateRequest2 = new PaymentUpdateRequest();
        paymentUpdateRequest2.setPaymentId(id);
        paymentUpdateRequest2.setPaymentStatus(status);

        assertEquals(paymentUpdateRequest.hashCode(), paymentUpdateRequest2.hashCode());
    }

}

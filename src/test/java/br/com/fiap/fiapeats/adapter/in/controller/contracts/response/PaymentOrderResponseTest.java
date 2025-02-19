package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentOrderResponseTest {

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        Long id = 1L;
        String status = "Pendente";
        String codigoQr = "codigoQR";

        PaymentOrderResponse response = PaymentOrderResponse.builder().build();
        response.setPaymentId(id);
        response.setPaymentStatus(status);
        response.setQrCode(codigoQr);

        PaymentOrderResponse response2 = PaymentOrderResponse.builder().build();
        response2.setPaymentId(id);
        response2.setPaymentStatus(status);
        response2.setQrCode(codigoQr);

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        Long id = 1L;
        String status = "Pendente";
        String codigoQr = "codigoQR";

        PaymentOrderResponse response = PaymentOrderResponse.builder().build();
        response.setPaymentId(id);
        response.setPaymentStatus(status);
        response.setQrCode(codigoQr);

        PaymentOrderResponse response2 = PaymentOrderResponse.builder().build();
        response2.setPaymentId(id);
        response2.setPaymentStatus(status);
        response2.setQrCode(codigoQr);

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

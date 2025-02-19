package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeignCreatePaymentResponseTest {

    @Test
    void testToString() {
        FeignCreatePaymentResponse response = FeignCreatePaymentResponse.builder().build();
        response.setQrCode("codigoQR");

        String expectedString = "FeignCreatePaymentResponse(" +
                "qrCode=codigoQR" +
                ')';

        assertEquals(expectedString, response.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        FeignCreatePaymentResponse response = FeignCreatePaymentResponse.builder().build();
        response.setQrCode("codigoQR");

        FeignCreatePaymentResponse response2 = FeignCreatePaymentResponse.builder().build();
        response2.setQrCode("codigoQR");

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        FeignCreatePaymentResponse response = new FeignCreatePaymentResponse();
        response.setQrCode("codigoQR");

        FeignCreatePaymentResponse response2 = new FeignCreatePaymentResponse();
        response2.setQrCode("codigoQR");

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

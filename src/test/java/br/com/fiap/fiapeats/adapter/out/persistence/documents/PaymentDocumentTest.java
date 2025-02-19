package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PaymentDocumentTest {

    @Test
    void testPaymentDocumentCreationUsingBuilder() {
        PaymentDocument paymentDocument = PaymentDocument.builder()
                .paymentId(123L)
                .paymentStatus("PENDING")
                .qrCode("sample-qrcode")
                .build();

        assertEquals(123L, paymentDocument.getPaymentId());
        assertEquals("PENDING", paymentDocument.getPaymentStatus());
        assertEquals("sample-qrcode", paymentDocument.getQrCode());
    }

    @Test
    void testPaymentDocumentWithNoData() {
        PaymentDocument paymentDocument = PaymentDocument.builder().build();

        assertNull(paymentDocument.getPaymentId());
        assertNull(paymentDocument.getPaymentStatus());
        assertNull(paymentDocument.getQrCode());
    }
}

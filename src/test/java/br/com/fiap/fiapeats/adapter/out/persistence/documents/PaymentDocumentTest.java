package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PaymentDocumentTest {

    private PaymentDocument payment;

    @BeforeEach
    void setUp() {
        payment = PaymentDocument.builder()
                .paymentId(1L)
                .paymentStatus("APPROVED")
                .qrCode("123456789")
                .build();
    }
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

    @Test
    void testGettersAndSetters() {
        PaymentDocument newPayment = PaymentDocument.builder().build();
        newPayment.setPaymentId(2L);
        newPayment.setPaymentStatus("PENDING");
        newPayment.setQrCode("987654321");

        assertThat(newPayment.getPaymentId()).isEqualTo(2L);
        assertThat(newPayment.getPaymentStatus()).isEqualTo("PENDING");
        assertThat(newPayment.getQrCode()).isEqualTo("987654321");
    }

    @Test
    void testBuilder() {
        assertThat(payment.getPaymentId()).isEqualTo(1L);
        assertThat(payment.getPaymentStatus()).isEqualTo("APPROVED");
        assertThat(payment.getQrCode()).isEqualTo("123456789");
    }

    @Test
    void testEqualsAndHashCode() {
        PaymentDocument payment1 = PaymentDocument.builder()
                .paymentId(1L)
                .paymentStatus("APPROVED")
                .qrCode("123456789")
                .build();

        PaymentDocument payment2 = PaymentDocument.builder()
                .paymentId(1L)
                .paymentStatus("APPROVED")
                .qrCode("123456789")
                .build();

        PaymentDocument payment3 = PaymentDocument.builder()
                .paymentId(2L)
                .paymentStatus("DECLINED")
                .qrCode("987654321")
                .build();

        assertThat(payment1).isEqualTo(payment2).hasSameHashCodeAs(payment2).isNotEqualTo(payment3);
        assertThat(payment1.hashCode()).isNotEqualTo(payment3.hashCode());
    }
    @Test
    void testToString() {
        String toString = payment.toString();
        assertThat(toString).contains("paymentId=1").contains("paymentStatus=APPROVED").contains("qrCode=123456789");
    }
}



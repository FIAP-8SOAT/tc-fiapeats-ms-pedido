package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PaymentUpdateRequest;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMapperImplTest {

    private final PaymentMapperImpl paymentMapper = new PaymentMapperImpl();

    @Test
    void testToPaymentUpdateStatusFromPaymentUpdateRequest() {
        PaymentUpdateRequest paymentUpdateRequest = new PaymentUpdateRequest();
        paymentUpdateRequest.setPaymentId(1L);
        paymentUpdateRequest.setPaymentStatus("COMPLETED");

        String orderId = "order123";

        PaymentUpdateStatus paymentUpdateStatus = paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(paymentUpdateRequest, orderId);

        assertNotNull(paymentUpdateStatus, "PaymentUpdateStatus não deve ser nulo");
        assertEquals(1L, paymentUpdateStatus.getPaymentId(), "PaymentId não foi mapeado corretamente");
        assertEquals("COMPLETED", paymentUpdateStatus.getPaymentStatus(), "PaymentStatus não foi mapeado corretamente");
        assertEquals(orderId, paymentUpdateStatus.getOrderId(), "OrderId não foi mapeado corretamente");
    }

    @Test
    void testToPaymentUpdateStatusFromPaymentUpdateRequestWhenPaymentUpdateRequestIsNull() {
        PaymentUpdateStatus paymentUpdateStatus = paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(null, "order123");

        assertNotNull(paymentUpdateStatus, "PaymentUpdateStatus não deve ser nulo");
        assertNull(paymentUpdateStatus.getPaymentId(), "PaymentId não deve ser mapeado");
        assertNull(paymentUpdateStatus.getPaymentStatus(), "PaymentStatus não deve ser mapeado");
        assertEquals("order123", paymentUpdateStatus.getOrderId(), "OrderId não foi mapeado corretamente");
    }

    @Test
    void testToPaymentUpdateStatusFromPaymentUpdateRequestWhenOrderIdIsNull() {
        PaymentUpdateRequest paymentUpdateRequest = new PaymentUpdateRequest();
        paymentUpdateRequest.setPaymentId(1L);
        paymentUpdateRequest.setPaymentStatus("PENDING");

        PaymentUpdateStatus paymentUpdateStatus = paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(paymentUpdateRequest, null);

        assertNotNull(paymentUpdateStatus, "PaymentUpdateStatus não deve ser nulo");
        assertEquals(1L, paymentUpdateStatus.getPaymentId(), "PaymentId não foi mapeado corretamente");
        assertEquals("PENDING", paymentUpdateStatus.getPaymentStatus(), "PaymentStatus não foi mapeado corretamente");
        assertNull(paymentUpdateStatus.getOrderId(), "OrderId deve ser nulo");
    }

    @Test
    void testToPaymentUpdateStatusFromPaymentUpdateRequestWhenBothAreNull() {
        PaymentUpdateStatus paymentUpdateStatus = paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(null, null);

        assertNull(paymentUpdateStatus, "PaymentUpdateStatus deve ser nulo quando ambos os parâmetros forem nulos");
    }
}

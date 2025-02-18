package br.com.fiap.fiapeats.adapter.in.controller.response;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CreateOrderResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateOrderResponseTest {

    @Test
    void testCreateOrderResponse() {
        String orderId = "12345";
        String taxId = "12345678901";
        String status = "PENDING";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.now();
        String qrCode = "QR12345";

        CreateOrderResponse response = CreateOrderResponse.builder()
                .orderId(orderId)
                .taxId(taxId)
                .status(status)
                .timeWaiting(timeWaiting)
                .createTimestamp(createTimestamp)
                .qrCode(qrCode)
                .build();

        assertEquals(orderId, response.getOrderId());
        assertEquals(taxId, response.getTaxId());
        assertEquals(status, response.getStatus());
        assertEquals(timeWaiting, response.getTimeWaiting());
        assertEquals(createTimestamp, response.getCreateTimestamp());
        assertEquals(qrCode, response.getQrCode());
    }
}

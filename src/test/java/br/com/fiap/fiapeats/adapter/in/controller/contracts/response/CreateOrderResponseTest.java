package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

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

        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrderId(orderId);
        response.setStatus(status);
        response.setTaxId(taxId);
        response.setTimeWaiting(timeWaiting);
        response.setCreateTimestamp(createTimestamp);
        response.setQrCode(qrCode);

        assertEquals(orderId, response.getOrderId());
        assertEquals(taxId, response.getTaxId());
        assertEquals(status, response.getStatus());
        assertEquals(timeWaiting, response.getTimeWaiting());
        assertEquals(createTimestamp, response.getCreateTimestamp());
        assertEquals(qrCode, response.getQrCode());
    }

    @Test
    void testToString() {
        String orderId = "12345";
        String taxId = "12345678901";
        String status = "PENDING";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.of(2025,10,13,15,10);
        String qrCode = "QR12345";

        CreateOrderResponse response = CreateOrderResponse.builder().build();
        response.setOrderId(orderId);
        response.setStatus(status);
        response.setTaxId(taxId);
        response.setTimeWaiting(timeWaiting);
        response.setCreateTimestamp(createTimestamp);
        response.setQrCode(qrCode);

        String expectedString = "CreateOrderResponse(" +
                "orderId=" + orderId +
                ", taxId=12345678901" +
                ", status=PENDING" +
                ", timeWaiting=10" +
                ", createTimestamp=2025-10-13T15:10" +
                ", qrCode=QR12345" +
                ')';

        assertEquals(expectedString, response.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        String orderId = "12345";
        String taxId = "12345678901";
        String status = "PENDING";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.of(2025,10,13,15,10);
        String qrCode = "QR12345";

        CreateOrderResponse response1 = CreateOrderResponse.builder()
                .orderId(orderId)
                .taxId(taxId)
                .status(status)
                .timeWaiting(timeWaiting)
                .createTimestamp(createTimestamp)
                .qrCode(qrCode)
                .build();

        CreateOrderResponse response2 = CreateOrderResponse.builder()
                .orderId(orderId)
                .taxId(taxId)
                .status(status)
                .timeWaiting(timeWaiting)
                .createTimestamp(createTimestamp)
                .qrCode(qrCode)
                .build();

        assertEquals(response1, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        String orderId = "12345";
        String taxId = "12345678901";
        String status = "PENDING";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.of(2025,10,13,15,10);
        String qrCode = "QR12345";

        CreateOrderResponse response1 = CreateOrderResponse.builder()
                .orderId(orderId)
                .taxId(taxId)
                .status(status)
                .timeWaiting(timeWaiting)
                .createTimestamp(createTimestamp)
                .qrCode(qrCode)
                .build();

        CreateOrderResponse response2 = CreateOrderResponse.builder()
                .orderId(orderId)
                .taxId(taxId)
                .status(status)
                .timeWaiting(timeWaiting)
                .createTimestamp(createTimestamp)
                .qrCode(qrCode)
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());
    }
}

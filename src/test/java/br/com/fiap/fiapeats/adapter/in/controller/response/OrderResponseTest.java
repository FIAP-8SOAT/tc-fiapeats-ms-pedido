package br.com.fiap.fiapeats.adapter.in.controller.response;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CategoryOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.OrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PaymentOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProductOrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderResponseTest {

    @Test
    void testOrderResponse() {
        UUID orderId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        String name = "produto";
        BigDecimal value = BigDecimal.TEN;
        String taxId = "12345678901";
        String status = "Pendente";
        String paymentStatus = "Pendente";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.now();
        String qrCode = "codigoQR";


        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse productOrderResponse = ProductOrderResponse.builder().build();
        productOrderResponse.setId(productId);
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(categoryOrderResponse);
        productOrderResponse.setImageUrl("url-image");

        PaymentOrderResponse paymentOrderResponse = PaymentOrderResponse.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderResponse response = OrderResponse.builder().build();
        response.setId(orderId);
        response.setProducts(List.of(productOrderResponse));
        response.setTaxId(taxId);
        response.setValue(value);
        response.setOrderStatus(status);
        response.setPayment(paymentOrderResponse);
        response.setCreateTimestamp(createTimestamp);
        response.setTimeWaiting(timeWaiting);

        assertEquals(orderId, response.getId());
        assertEquals(1, response.getProducts().size());
        assertEquals(productId, response.getProducts().get(0).getId());
        assertEquals(name, response.getProducts().get(0).getName());
        assertEquals(name, response.getProducts().get(0).getDescription());
        assertEquals(value, response.getProducts().get(0).getValue());
        assertEquals(1L, response.getProducts().get(0).getCategory().getId());
        assertEquals("Bebida", response.getProducts().get(0).getCategory().getDescription());
        assertEquals("url-image", response.getProducts().get(0).getImageUrl());
        assertEquals(taxId, response.getTaxId());
        assertEquals(value, response.getValue());
        assertEquals(status, response.getOrderStatus());
        assertEquals(1L, response.getPayment().getPaymentId());
        assertEquals(paymentStatus, response.getPayment().getPaymentStatus());
        assertEquals(qrCode, response.getPayment().getQrCode());
        assertEquals(createTimestamp, response.getCreateTimestamp());
        assertEquals(timeWaiting, response.getTimeWaiting());

    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        String name = "produto";
        BigDecimal value = BigDecimal.TEN;
        String taxId = "12345678901";
        String status = "Pendente";
        String paymentStatus = "Pendente";
        int timeWaiting = 10;
        LocalDateTime createTimestamp = LocalDateTime.of(2025,10,13,15,10);
        String qrCode = "codigoQR";

        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse productOrderResponse = ProductOrderResponse.builder().build();
        productOrderResponse.setId(productId);
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(categoryOrderResponse);
        productOrderResponse.setImageUrl("url-image");

        PaymentOrderResponse paymentOrderResponse = PaymentOrderResponse.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderResponse response = OrderResponse.builder().build();
        response.setId(orderId);
        response.setProducts(List.of(productOrderResponse));
        response.setTaxId(taxId);
        response.setValue(value);
        response.setOrderStatus(status);
        response.setPayment(paymentOrderResponse);
        response.setCreateTimestamp(createTimestamp);
        response.setTimeWaiting(timeWaiting);


        String expectedString = "OrderResponse(" +
                "id=" + orderId +
                ", products=" + List.of(productOrderResponse) +
                ", taxId=12345678901" +
                ", value=10" +
                ", orderStatus=Pendente" +
                ", payment=" + paymentOrderResponse +
                ", createTimestamp=2025-10-13T15:10" +
                ", timeWaiting=10" +
                ')';

        assertEquals(expectedString, response.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        UUID orderId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        String name = "produto";
        BigDecimal value = BigDecimal.TEN;
        String paymentStatus = "Pendente";
        String qrCode = "codigoQR";

        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse productOrderResponse = ProductOrderResponse.builder().build();
        productOrderResponse.setId(productId);
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(categoryOrderResponse);
        productOrderResponse.setImageUrl("url-image");

        PaymentOrderResponse paymentOrderResponse = PaymentOrderResponse.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderResponse order1 = OrderResponse.builder()
                .id(orderId)
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        OrderResponse order2 = OrderResponse.builder()
                .id(orderId)
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        assertEquals(order1, order2);
        assertEquals(order1.getProducts(), order2.getProducts());
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        UUID orderId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        String name = "produto";
        BigDecimal value = BigDecimal.TEN;
        String paymentStatus = "Pendente";
        String qrCode = "codigoQR";

        CategoryOrderResponse categoryOrderResponse = CategoryOrderResponse.builder().build();
        categoryOrderResponse.setId(1L);
        categoryOrderResponse.setDescription("Bebida");

        ProductOrderResponse productOrderResponse = ProductOrderResponse.builder().build();
        productOrderResponse.setId(productId);
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(categoryOrderResponse);
        productOrderResponse.setImageUrl("url-image");

        PaymentOrderResponse paymentOrderResponse = PaymentOrderResponse.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderResponse order1 = OrderResponse.builder()
                .id(orderId)
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        OrderResponse order2 = OrderResponse.builder()
                .id(orderId)
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        assertEquals(order1.hashCode(), order2.hashCode());
        assertEquals(order1.getPayment().hashCode(), order2.getPayment().hashCode());
    }
}
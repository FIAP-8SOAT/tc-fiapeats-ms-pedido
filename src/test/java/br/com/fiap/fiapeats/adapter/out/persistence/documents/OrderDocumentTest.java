package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import br.com.fiap.fiapeats.core.domain.Category;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderDocumentTest {

    @Test
    void testConstructorAndGetters() {
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

        Category category = new Category(1L, "Bebida");

        ProductDocument productDocument = ProductDocument.builder().build();
        productDocument.setId(productId.toString());
        productDocument.setName(name);
        productDocument.setDescription(name);
        productDocument.setValue(value);
        productDocument.setCategory(category);
        productDocument.setImageUrl("url-image");

        PaymentDocument paymentDocument = PaymentDocument.builder().build();
        paymentDocument.setPaymentId(1L);
        paymentDocument.setPaymentStatus(paymentStatus);
        paymentDocument.setQrCode(qrCode);

        OrderDocument response = OrderDocument.builder().build();
        response.setId(orderId.toString());
        response.setProducts(List.of(productDocument));
        response.setTaxId(taxId);
        response.setValue(value);
        response.setOrderStatus(status);
        response.setPayment(paymentDocument);
        response.setCreateTimestamp(createTimestamp);
        response.setTimeWaiting(timeWaiting);

        assertEquals(orderId.toString(), response.getId());
        assertEquals(1, response.getProducts().size());
        assertEquals("produto", response.getProducts().get(0).getDescription());
        assertEquals("12345678901", response.getTaxId());
        assertEquals(new BigDecimal(10), response.getValue());
        assertEquals("Pendente", response.getOrderStatus());
        assertNotNull(response.getCreateTimestamp());
        assertEquals(10, response.getTimeWaiting());
    }

    @Test
    void testCreateOrderDocument() {
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

        Category category = new Category(1L, "Bebida");

        ProductDocument productDocument = ProductDocument.builder().build();
        productDocument.setId(productId.toString());
        productDocument.setName(name);
        productDocument.setDescription(name);
        productDocument.setValue(value);
        productDocument.setCategory(category);
        productDocument.setImageUrl("url-image");

        PaymentDocument paymentDocument = PaymentDocument.builder().build();
        paymentDocument.setPaymentId(1L);
        paymentDocument.setPaymentStatus(paymentStatus);
        paymentDocument.setQrCode(qrCode);

        OrderDocument response = OrderDocument.builder().build();
        response.setId(orderId.toString());
        response.setProducts(List.of(productDocument));
        response.setTaxId(taxId);
        response.setValue(value);
        response.setOrderStatus(status);
        response.setPayment(paymentDocument);
        response.setCreateTimestamp(createTimestamp);
        response.setTimeWaiting(timeWaiting);

        assertEquals(orderId.toString(), response.getId());
        assertEquals(1, response.getProducts().size());
        assertEquals(productId.toString(), response.getProducts().get(0).getId());
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

        Category category = new Category(1L, "Bebida");

        ProductDocument productOrderResponse = ProductDocument.builder().build();
        productOrderResponse.setId(productId.toString());
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(category);
        productOrderResponse.setImageUrl("url-image");

        PaymentDocument paymentOrderResponse = PaymentDocument.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderDocument response = OrderDocument.builder().build();
        response.setId(orderId.toString());
        response.setProducts(List.of(productOrderResponse));
        response.setTaxId(taxId);
        response.setValue(value);
        response.setOrderStatus(status);
        response.setPayment(paymentOrderResponse);
        response.setCreateTimestamp(createTimestamp);
        response.setTimeWaiting(timeWaiting);


        String expectedString = "OrderDocument(" +
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

        Category category = new Category(1L, "Bebida");

        ProductDocument productOrderResponse = ProductDocument.builder().build();
        productOrderResponse.setId(productId.toString());
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(category);
        productOrderResponse.setImageUrl("url-image");

        PaymentDocument paymentOrderResponse = PaymentDocument.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderDocument order1 = OrderDocument.builder()
                .id(orderId.toString())
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        OrderDocument order2 = OrderDocument.builder()
                .id(orderId.toString())
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

        Category category = new Category(1L, "Bebida");

        ProductDocument productOrderResponse = ProductDocument.builder().build();
        productOrderResponse.setId(productId.toString());
        productOrderResponse.setName(name);
        productOrderResponse.setDescription(name);
        productOrderResponse.setValue(value);
        productOrderResponse.setCategory(category);
        productOrderResponse.setImageUrl("url-image");

        PaymentDocument paymentOrderResponse = PaymentDocument.builder().build();
        paymentOrderResponse.setPaymentId(1L);
        paymentOrderResponse.setPaymentStatus(paymentStatus);
        paymentOrderResponse.setQrCode(qrCode);

        OrderDocument order1 = OrderDocument.builder()
                .id(orderId.toString())
                .products(List.of(productOrderResponse))
                .taxId("123.456.789-00")
                .value(BigDecimal.valueOf(200.00))
                .orderStatus("PAGO")
                .payment(paymentOrderResponse)
                .createTimestamp(LocalDateTime.of(2025, 2, 18, 14, 30))
                .timeWaiting(120)
                .build();

        OrderDocument order2 = OrderDocument.builder()
                .id(orderId.toString())
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

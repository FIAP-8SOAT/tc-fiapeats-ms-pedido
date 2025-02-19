package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CreateOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.OrderResponse;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.PaymentDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.ProductDocument;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperImplTest {

    @Mock
    private ProductDocument product;

    @Mock
    private OrderDocument orderDocument;

    private final OrderMapperImpl orderMapper = new OrderMapperImpl(); // Implementação do OrderMapper

    @Test
    void testToOrderFromOrderRequest() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setTaxId("12345678900");
        createOrderRequest.setValue(BigDecimal.valueOf(300.00));
        createOrderRequest.setIdProducts(List.of(UUID.randomUUID(), UUID.randomUUID()));

        Order order = orderMapper.toOrderFromOrderRequest(createOrderRequest);

        assertNotNull(order, "Order não deve ser nulo");
        assertEquals("12345678900", order.getTaxId(), "TaxId não foi mapeado corretamente");
        assertEquals(BigDecimal.valueOf(300.00), order.getValue(), "Value não foi mapeado corretamente");
    }

    @Test
    void testToCreateOrderResponseFromOrder() {
        Order order = new Order(UUID.randomUUID(), null, "12345678900", BigDecimal.valueOf(100.00), "PENDING", "PENDING", 1L, LocalDateTime.now(), 15, "QRCode");

        CreateOrderResponse createOrderResponse = orderMapper.toCreateOrderResponseFromOrder(order);

        assertNotNull(createOrderResponse, "CreateOrderResponse não deve ser nulo");
        assertEquals(order.getQrCode(), createOrderResponse.getQrCode(), "QR Code não foi mapeado corretamente");
    }

    @Test
    void testToOrderFromOrderDocument() {

        var createDate = LocalDateTime.now();
        ProductDocument productDocument = ProductDocument.builder().id(UUID.randomUUID().toString()).name("Produto").description("Produto Teste").value(BigDecimal.TEN).category(new Category(1L, "Bebida")).build();
        PaymentDocument paymentDocument = PaymentDocument.builder().paymentId(1L).paymentStatus("Pendente").qrCode("codigoQR").build();
        orderDocument = OrderDocument.builder().id("123e4567-e89b-12d3-a456-426614174000").products(List.of(productDocument)).taxId("12345678901").value(BigDecimal.TEN).orderStatus("Pendente").payment(paymentDocument).createTimestamp(createDate).timeWaiting(15).build();

        Order order = orderMapper.toOrderFromOrderDocument(orderDocument);

        assertNotNull(order, "Order não deve ser nulo");
        assertEquals(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), order.getId(), "ID da ordem não foi mapeado corretamente");
        assertEquals("12345678901", order.getTaxId(), "TaxId não foi mapeado corretamente");
        assertEquals(BigDecimal.valueOf(10), order.getValue(), "Valor não foi mapeado corretamente");
        assertEquals("Pendente", order.getOrderStatus(), "Status da ordem não foi mapeado corretamente");
        assertNotNull(createDate, "Data de criação não foi mapeada corretamente");
        assertEquals(15, order.getTimeWaiting(), "Tempo de espera não foi mapeado corretamente");
        assertNotNull(order.getProducts(), "Produtos não foram mapeados corretamente");
    }

    @Test
    void testToOrderFromOrderRequestWithNull() {
        Order order = orderMapper.toOrderFromOrderRequest(null);

        assertNull(order, "Order deve ser nulo quando o CreateOrderRequest for nulo");
    }

    @Test
    void testToCreateOrderResponseFromOrderWithNull() {
        CreateOrderResponse response = orderMapper.toCreateOrderResponseFromOrder(null);

        assertNull(response, "CreateOrderResponse deve ser nulo quando o Order for nulo");
    }

    @Test
    void testToOrderFromOrderDocumentWithNull() {
        Order order = orderMapper.toOrderFromOrderDocument(null);

        assertNull(order, "Order deve ser nulo quando o OrderDocument for nulo");
    }

    @Test
    void testToOrderResponseFromOrder() {
        Order order = new Order(UUID.randomUUID(), null, "12345678900", BigDecimal.valueOf(150.00), "PENDING", "PENDING", 2L, LocalDateTime.now(), 30, "QRCode");

        OrderResponse orderResponse = orderMapper.toOrderResponseFromOrder(order);

        assertNotNull(orderResponse, "OrderResponse não deve ser nulo");
        assertEquals(order.getId(), orderResponse.getId(), "ID não foi mapeado corretamente");
        assertEquals(order.getOrderStatus(), orderResponse.getOrderStatus(), "OrderStatus não foi mapeado corretamente");
    }

    @Test
    void testToOrderFromOrderRequestWhenNull() {
        Order order = orderMapper.toOrderFromOrderRequest(null);

        assertNull(order, "Order deve ser nulo");
    }

    @Test
    void testToOrderDocumentFromOrderWhenNull() {
        OrderDocument orderDocument = orderMapper.toOrderDocumentFromOrder(null);

        assertNull(orderDocument, "OrderDocument deve ser nulo");
    }

    @Test
    void testToCreateOrderResponseFromOrderWhenNull() {
        CreateOrderResponse createOrderResponse = orderMapper.toCreateOrderResponseFromOrder(null);

        assertNull(createOrderResponse, "CreateOrderResponse deve ser nulo");
    }

    @Test
    void testToOrderFromOrderDocumentWhenNull() {
        Order order = orderMapper.toOrderFromOrderDocument(null);

        assertNull(order, "Order deve ser nulo");
    }

    @Test
    void testToOrderResponseFromOrderWhenNull() {
        OrderResponse orderResponse = orderMapper.toOrderResponseFromOrder(null);

        assertNull(orderResponse, "OrderResponse deve ser nulo");
    }
}

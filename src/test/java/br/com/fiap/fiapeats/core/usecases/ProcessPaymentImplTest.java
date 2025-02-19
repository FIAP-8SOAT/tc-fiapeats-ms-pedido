package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.PaymentDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.ProductDocument;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.PaymentUpdateStatus;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.ports.out.PaymentUpdatePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcessPaymentImplTest {

    @Mock
    private PaymentUpdatePort paymentUpdatePort;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private ProcessPaymentImpl processPaymentImpl;

    private OrderDocument orderDocument;
    private PaymentUpdateStatus paymentUpdateStatus;
    private Order order;
    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ProductDocument productDocument = ProductDocument.builder().id(UUID.randomUUID().toString()).name("Produto").description("Produto Teste").value(BigDecimal.TEN).category(new Category(1L, "Bebida")).build();
        PaymentDocument paymentDocument = PaymentDocument.builder().paymentId(1L).paymentStatus("Pendente").qrCode("codigoQR").build();
        orderDocument = OrderDocument.builder().id(UUID.randomUUID().toString()).products(List.of(productDocument)).taxId("12345678901").value(BigDecimal.TEN).orderStatus("Pendente").payment(paymentDocument).createTimestamp(LocalDateTime.now()).timeWaiting(15).build();

        product = new Product(UUID.randomUUID(), "produto", "produto", BigDecimal.TEN, new Category(1L, "Bebida"), null);
        order = new Order(UUID.randomUUID(), List.of(product), null, BigDecimal.TEN, "Pendente", "Pendente", 1L, LocalDateTime.now(), 15, "codigoQR");

        paymentUpdateStatus = new PaymentUpdateStatus("orderId", 2L, "COMPLETED");
    }

    @Test
    void testUpdatePayment_Success() {
        when(paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId())).thenReturn(Optional.of(orderDocument));
        when(orderMapper.toOrderFromOrderDocument(orderDocument)).thenReturn(order);
        when(orderMapper.toOrderDocumentFromOrder(order)).thenReturn(orderDocument);

        processPaymentImpl.updatePayment(paymentUpdateStatus);

        assertEquals(2L, order.getPaymentId());
        assertEquals("COMPLETED", order.getPaymentStatus());
        verify(paymentUpdatePort).update(orderDocument);
    }

    @Test
    void testUpdatePayment_OrderNotFound() {
        when(paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId())).thenReturn(Optional.empty());

        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> processPaymentImpl.updatePayment(paymentUpdateStatus));
        assertEquals("Ordem orderId não existe na base", exception.getMessage());
    }

    @Test
    void testUpdatePayment_MapperException() {
        when(paymentUpdatePort.getOrder(paymentUpdateStatus.getOrderId())).thenReturn(Optional.of(orderDocument));
        when(orderMapper.toOrderFromOrderDocument(orderDocument)).thenThrow(new RuntimeException("Mapper error"));

        Exception exception = assertThrows(RuntimeException.class, () -> processPaymentImpl.updatePayment(paymentUpdateStatus));
        assertEquals("Mapper error", exception.getMessage());
    }
}

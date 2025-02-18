package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.PaymentDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.ProductDocument;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.ports.out.GetListOrderPort;
import br.com.fiap.fiapeats.core.ports.out.GetSingleOrderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GetOrderImplTest {

    @InjectMocks
    private GetOrderImpl getOrderImpl;

    @Mock
    private GetSingleOrderPort getSingleOrderPort;

    @Mock
    private GetListOrderPort getListOrderPort;

    @Mock
    private OrderMapper orderMapper;

    private final String orderId = "1234";
    private final GetOrderHeaderRequest request = mock(GetOrderHeaderRequest.class);
    private Order order;
    private Product product;
    private OrderDocument orderDocument;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product(UUID.randomUUID(), "produto", "produto", BigDecimal.TEN, new Category(1L, "Bebida"), null);
        order = new Order(UUID.randomUUID(), List.of(product), null, BigDecimal.TEN, "Pendente", "Pendente", 1L, LocalDateTime.now(), 15, "codigoQR");
        ProductDocument productDocument = ProductDocument.builder().id(UUID.randomUUID().toString()).name("Produto").description("Produto Teste").value(BigDecimal.TEN).category(new Category(1L, "Bebida")).build();
        PaymentDocument paymentDocument = PaymentDocument.builder().paymentId(1L).paymentStatus("Pendente").qrCode("codigoQR").build();
        orderDocument = OrderDocument.builder().id(UUID.randomUUID().toString()).products(List.of(productDocument)).taxId("12345678901").value(BigDecimal.TEN).orderStatus("Pendente").payment(paymentDocument).createTimestamp(LocalDateTime.now()).timeWaiting(15).build();
    }

    @Test
    void testGetOrderById_OrderExists() {
        when(getSingleOrderPort.getOrderById(any())).thenReturn(Optional.of(orderDocument));
        when(orderMapper.toOrderFromOrderDocument(any())).thenReturn(order);

        Order result = getOrderImpl.getOrderById(orderId);

        assertNotNull(result);
        assertEquals(order, result);
        verify(getSingleOrderPort, times(1)).getOrderById(orderId);
    }

    @Test
    void testGetOrderById_OrderNotFound() {
        when(getSingleOrderPort.getOrderById(orderId)).thenReturn(Optional.empty());

        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> {
            getOrderImpl.getOrderById(orderId);
        });

        assertEquals(String.format("Ordem %s não encontrada", orderId), exception.getMessage());
        verify(getSingleOrderPort, times(1)).getOrderById(orderId);
    }

    @Test
    void testGetOrderByParameters() {
        when(getListOrderPort.getOrderByHeaders(request)).thenReturn(orderDocument);
        when(orderMapper.toOrderFromOrderDocument(orderDocument)).thenReturn(order);

        Order result = getOrderImpl.getOrderByParameters(request);

        assertNotNull(result);
        assertEquals(order, result);
        verify(getListOrderPort, times(1)).getOrderByHeaders(request);
    }
}

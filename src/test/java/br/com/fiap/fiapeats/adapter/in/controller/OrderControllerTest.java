package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.*;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.ports.in.GetOrderPort;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private ProcessOrderPort processOrderPort;
    @Mock
    private GetOrderPort getOrderPort;
    private Order order;
    private Product product;
    private CreateOrderRequest createOrderRequest;
    private CreateOrderResponse createOrderResponse;
    private OrderResponse orderResponse;
    private GetOrderHeaderRequest getOrderHeaderRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product(UUID.randomUUID(), "Produto", "Produto Teste", new BigDecimal(100), new Category(1L, "Bebida"), null);
        order = new Order(UUID.randomUUID(), List.of(product), "12345678901", new BigDecimal(100), "Pendente", "Pendente", 1L, LocalDateTime.now(), 15, "codigoQR");
        createOrderRequest = new CreateOrderRequest(List.of(UUID.randomUUID(), UUID.randomUUID()), "12345678901", new BigDecimal(100));
        createOrderResponse = new CreateOrderResponse(UUID.randomUUID().toString(), "12345678901", "Pendente", 15, LocalDateTime.now(), "codigoQR");
        ProductOrderResponse productOrderResponse = ProductOrderResponse.builder().id(UUID.randomUUID()).name("Produto").description("Produto teste").value(BigDecimal.TEN).category(CategoryOrderResponse.builder().id(1L).description("Bebida").build()).build();
        PaymentOrderResponse paymentOrderResponse = PaymentOrderResponse.builder().paymentId(2L).paymentStatus("Pendente").qrCode("codigoQR").build();
        orderResponse = OrderResponse.builder().id(UUID.randomUUID()).products(List.of(productOrderResponse)).taxId("12345678901").value(BigDecimal.TEN).orderStatus("Pendente").payment(paymentOrderResponse).createTimestamp(LocalDateTime.now()).timeWaiting(15).build();
        getOrderHeaderRequest = new GetOrderHeaderRequest(UUID.randomUUID().toString(), "Produto", "Produto Teste", "100", 1L, "Bebida", "12345678901", "100", "Pendente", "Pendente", 1L, LocalDateTime.now(), 15);
    }

    @Test
    void shouldCreateNewOrderWithSuccess() throws Exception {

        when(orderMapper.toOrderFromOrderRequest(any())).thenReturn(order);
        when(processOrderPort.process(any())).thenReturn(order);
        when(orderMapper.toCreateOrderResponseFromOrder(order)).thenReturn(createOrderResponse);

        ResponseEntity<CreateOrderResponse> response = orderController.createNewOrder(createOrderRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(createOrderResponse, response.getBody());

        verify(orderMapper, times(1)).toOrderFromOrderRequest(any());
        verify(orderMapper, times(1)).toCreateOrderResponseFromOrder(order);
        verify(processOrderPort, times(1)).process(any());
    }

    @Test
    void shouldReturnOrderByIdWithSuccess() {

        when(getOrderPort.getOrderById("123456")).thenReturn(order);
        when(orderMapper.toOrderResponseFromOrder(order)).thenReturn(orderResponse);

        ResponseEntity<OrderResponse> response = orderController.getOrderById("123456", "correlationId");

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orderResponse, response.getBody());

        verify(orderMapper, times(1)).toOrderResponseFromOrder(any());
        verify(getOrderPort, times(1)).getOrderById(any());
    }

    @Test
    void shouldReturnOrderByHeadersWithSuccess() {

        List<ResponseEntity<OrderResponse>> response = orderController.getOrderByHeaders(getOrderHeaderRequest, "correlationId");

        assertEquals(HttpStatus.OK, response.get(0).getStatusCode());

        verify(getOrderPort, times(1)).getOrderByParameters(any());
    }
}

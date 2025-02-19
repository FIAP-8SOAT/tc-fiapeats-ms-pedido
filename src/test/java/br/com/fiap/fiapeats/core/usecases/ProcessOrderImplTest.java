package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Client;
import br.com.fiap.fiapeats.core.domain.Order;
import br.com.fiap.fiapeats.core.domain.Product;
import br.com.fiap.fiapeats.core.exceptions.FeignRequestException;
import br.com.fiap.fiapeats.core.exceptions.ProductNotFoundException;
import br.com.fiap.fiapeats.core.ports.out.FeignCreatePaymentPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindClientPort;
import br.com.fiap.fiapeats.core.ports.out.FeignFindProductsPort;
import br.com.fiap.fiapeats.core.ports.out.SaveOrderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcessOrderImplTest {

    @Mock
    private FeignFindProductsPort feignFindProductsPort;

    @Mock
    private SaveOrderPort saveOrderPort;

    @Mock
    private FeignFindClientPort feignFindClientPort;

    @Mock
    private FeignCreatePaymentPort feignCreatePaymentPort;

    @InjectMocks
    private ProcessOrderImpl processOrderImpl;

    private Order order;
    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product(UUID.randomUUID(), "Produto", "Produto Teste", new BigDecimal(100), new Category(1L, "Bebida"), null);
        order = new Order(UUID.randomUUID(), List.of(product), "12345678901", new BigDecimal(100), "Pendente", "Pendente", 1L, LocalDateTime.now(), 15, "codigoQR");
    }

    @Test
    void testProcess_SuccessfulOrder() {
        when(feignFindProductsPort.getAllProducts()).thenReturn(List.of(product));
        when(feignFindClientPort.findClient(order.getTaxId())).thenReturn(new Client("nome", "nome@teste.com", "1234567890"));
        when(feignCreatePaymentPort.createPayment(any())).thenReturn("QR_CODE_123");

        Order processedOrder = processOrderImpl.process(order);

        assertNotNull(processedOrder);
        assertEquals(order.getId(), processedOrder.getId());
        assertEquals("QR_CODE_123", processedOrder.getQrCode());
        verify(feignFindProductsPort).getAllProducts();
        verify(feignFindClientPort).findClient(order.getTaxId());
        verify(feignCreatePaymentPort).createPayment(any());
        verify(saveOrderPort).save(any());
    }

    @Test
    void testProcess_ClientNotFound() {
        when(feignFindClientPort.findClient(order.getTaxId())).thenThrow(ProductNotFoundException.class);

        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> processOrderImpl.process(order));
        assertEquals("Existem produtos na lista que não estão na base", exception.getMessage());
    }

    @Test
    void testValidClient_Success() {
        when(feignFindClientPort.findClient(order.getTaxId())).thenReturn(new Client("nome", "nome@teste.com", "1234567890"));

        processOrderImpl.validClient(order);

        assertEquals("12345678901", order.getTaxId());
        verify(feignFindClientPort, times(1)).findClient(order.getTaxId());
    }

    @Test
    void testValidClient_ClientNotFound() {
        when(feignFindClientPort.findClient(order.getTaxId())).thenThrow(new FeignRequestException("Client not found"));

        FeignRequestException exception = assertThrows(FeignRequestException.class, () -> processOrderImpl.validClient(order));
        assertEquals("Client not found", exception.getMessage());
    }
}

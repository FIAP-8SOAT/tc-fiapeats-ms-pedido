package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.PaymentDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.ProductDocument;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.OrderRepository;
import br.com.fiap.fiapeats.core.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveOrderImplTest {

    @InjectMocks
    private SaveOrderImpl saveOrder;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderMapper orderMapper;
    private OrderDocument orderDocument;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ProductDocument productDocument = ProductDocument.builder().id(UUID.randomUUID().toString()).name("Produto").description("Produto Teste").value(BigDecimal.TEN).category(new Category(1L, "Bebida")).build();
        PaymentDocument paymentDocument = PaymentDocument.builder().paymentId(1L).paymentStatus("Pendente").qrCode("codigoQR").build();
        orderDocument = OrderDocument.builder().id(UUID.randomUUID().toString()).products(List.of(productDocument)).taxId("12345678901").value(BigDecimal.TEN).orderStatus("Pendente").payment(paymentDocument).createTimestamp(LocalDateTime.now()).timeWaiting(15).build();
    }

    @Test
    void shouldUpdateWithSuccess() {
        when(orderMapper.toOrderDocumentFromOrder(any())).thenReturn(orderDocument);

        saveOrder.save(any());

        verify(orderMapper, times(1)).toOrderDocumentFromOrder(any());
        verify(orderRepository, times(1)).save(any());
    }

}

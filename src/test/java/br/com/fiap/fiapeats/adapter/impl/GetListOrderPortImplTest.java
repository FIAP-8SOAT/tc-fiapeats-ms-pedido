package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetListOrderPortImplTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private GetListOrderPortImpl getListOrderPortImpl;

    private GetOrderHeaderRequest request;

    @BeforeEach
    public void setUp() {
        request = new GetOrderHeaderRequest();
        request.setProdutoId(UUID.randomUUID().toString());
        request.setProdutoNome("Produto Teste");
        request.setProdutoDescricao("Descrição Teste");
        request.setProdutoValor("100.00");
        request.setCategoriaId(10L);
        request.setCategoriaDescricao("Categoria Teste");
        request.setCpf("12345678900");
        request.setValor("150.00");
        request.setStatusOrdem("PENDING");
        request.setPagamentoStatus("PAID");
        request.setPagamentoId(1L);
        request.setDataCriacao(LocalDateTime.now());
        request.setTempoEspera(5);
    }

    @Test
    public void testGetOrderByHeaders_WithEmptyRequest() {
        when(mongoTemplate.findOne(Mockito.any(Query.class), eq(OrderDocument.class)))
                .thenReturn(null);

        GetOrderHeaderRequest emptyRequest = new GetOrderHeaderRequest();

        OrderDocument result = getListOrderPortImpl.getOrderByHeaders(emptyRequest);

        assertNull(result);
        verify(mongoTemplate, times(1)).findOne(Mockito.any(Query.class), eq(OrderDocument.class));
    }

    @Test
    public void testGetOrderByHeaders_WhenNoCriteriaMatches() {
        when(mongoTemplate.findOne(Mockito.any(Query.class), eq(OrderDocument.class)))
                .thenReturn(null);

        GetOrderHeaderRequest noMatchRequest = new GetOrderHeaderRequest();
        noMatchRequest.setProdutoId(UUID.randomUUID().toString());

        OrderDocument result = getListOrderPortImpl.getOrderByHeaders(noMatchRequest);

        assertNull(result);
        verify(mongoTemplate, times(1)).findOne(Mockito.any(Query.class), eq(OrderDocument.class));
    }
}

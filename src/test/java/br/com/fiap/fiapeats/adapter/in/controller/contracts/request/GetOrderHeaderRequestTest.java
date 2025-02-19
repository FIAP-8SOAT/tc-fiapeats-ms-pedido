package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class GetOrderHeaderRequestTest {

    @Test
    void testConstructorAndGetters() {
        GetOrderHeaderRequest request = new GetOrderHeaderRequest(
                "prod1",
                "Produto 1",
                "Descrição do produto 1",
                "100.00",
                1L,
                "Categoria 1",
                "12345678901",
                "150.00",
                "Pendente",
                "Pago",
                1L,
                LocalDateTime.now(),
                30
        );

        assertEquals("prod1", request.getProdutoId());
        assertEquals("Produto 1", request.getProdutoNome());
        assertEquals("Descrição do produto 1", request.getProdutoDescricao());
        assertEquals("100.00", request.getProdutoValor());
        assertEquals(1L, request.getCategoriaId());
        assertEquals("Categoria 1", request.getCategoriaDescricao());
        assertEquals("12345678901", request.getCpf());
        assertEquals("150.00", request.getValor());
        assertEquals("Pendente", request.getStatusOrdem());
        assertEquals("Pago", request.getPagamentoStatus());
        assertEquals(1L, request.getPagamentoId());
        assertNotNull(request.getDataCriacao());
        assertEquals(30, request.getTempoEspera());
    }

    @Test
    void testNoArgsConstructor() {
        GetOrderHeaderRequest request = new GetOrderHeaderRequest();

        assertNull(request.getProdutoId());
        assertNull(request.getProdutoNome());
        assertNull(request.getProdutoDescricao());
        assertNull(request.getProdutoValor());
        assertNull(request.getCategoriaId());
        assertNull(request.getCategoriaDescricao());
        assertNull(request.getCpf());
        assertNull(request.getValor());
        assertNull(request.getStatusOrdem());
        assertNull(request.getPagamentoStatus());
        assertNull(request.getPagamentoId());
        assertNull(request.getDataCriacao());
        assertEquals(0, request.getTempoEspera());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        UUID productId = UUID.randomUUID();
        String name = "produto";
        String value = "100";
        String status = "Pendente";

        GetOrderHeaderRequest orderHeaderRequest = new GetOrderHeaderRequest();
        orderHeaderRequest.setProdutoId(productId.toString());
        orderHeaderRequest.setProdutoNome(name);
        orderHeaderRequest.setProdutoDescricao(name);
        orderHeaderRequest.setProdutoValor(value);
        orderHeaderRequest.setCategoriaId(1L);
        orderHeaderRequest.setCategoriaDescricao("Bebida");
        orderHeaderRequest.setCpf("123.456.789-00");
        orderHeaderRequest.setValor(value);
        orderHeaderRequest.setStatusOrdem(status);
        orderHeaderRequest.setPagamentoStatus(status);
        orderHeaderRequest.setPagamentoId(1L);

        GetOrderHeaderRequest orderHeaderRequest2 = new GetOrderHeaderRequest();
        orderHeaderRequest2.setProdutoId(productId.toString());
        orderHeaderRequest2.setProdutoNome(name);
        orderHeaderRequest2.setProdutoDescricao(name);
        orderHeaderRequest2.setProdutoValor(value);
        orderHeaderRequest2.setCategoriaId(1L);
        orderHeaderRequest2.setCategoriaDescricao("Bebida");
        orderHeaderRequest2.setCpf("123.456.789-00");
        orderHeaderRequest2.setValor(value);
        orderHeaderRequest2.setStatusOrdem(status);
        orderHeaderRequest2.setPagamentoStatus(status);
        orderHeaderRequest2.setPagamentoId(1L);

        assertEquals(orderHeaderRequest, orderHeaderRequest2);
    }

    @Test
    void testNotEquals_shouldReturnTrue() {
        UUID productId = UUID.randomUUID();
        String name = "produto";
        String value = "100";
        String status = "Pendente";

        GetOrderHeaderRequest orderHeaderRequest = new GetOrderHeaderRequest();
        orderHeaderRequest.setProdutoId(productId.toString());
        orderHeaderRequest.setProdutoNome(name);
        orderHeaderRequest.setProdutoDescricao(name);
        orderHeaderRequest.setProdutoValor(value);
        orderHeaderRequest.setCategoriaId(1L);
        orderHeaderRequest.setCategoriaDescricao("Bebida");
        orderHeaderRequest.setCpf("123.456.789-00");
        orderHeaderRequest.setValor(value);
        orderHeaderRequest.setStatusOrdem(status);
        orderHeaderRequest.setPagamentoStatus(status);
        orderHeaderRequest.setPagamentoId(1L);

        GetOrderHeaderRequest orderHeaderRequest2 = new GetOrderHeaderRequest();
        orderHeaderRequest2.setProdutoId(productId.toString());
        orderHeaderRequest2.setProdutoNome(name);
        orderHeaderRequest2.setProdutoDescricao(name);
        orderHeaderRequest2.setProdutoValor(value);
        orderHeaderRequest2.setCategoriaId(2L);
        orderHeaderRequest2.setCategoriaDescricao("Lanche");
        orderHeaderRequest2.setCpf("123.456.789-00");
        orderHeaderRequest2.setValor(value);
        orderHeaderRequest2.setStatusOrdem(status);
        orderHeaderRequest2.setPagamentoStatus(status);
        orderHeaderRequest2.setPagamentoId(1L);

        assertNotEquals(orderHeaderRequest, orderHeaderRequest2);

        assertNotEquals(orderHeaderRequest.hashCode(), orderHeaderRequest2.hashCode());
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        UUID productId = UUID.randomUUID();
        String name = "produto";
        String value = "100";
        String status = "Pendente";

        GetOrderHeaderRequest orderHeaderRequest = new GetOrderHeaderRequest();
        orderHeaderRequest.setProdutoId(productId.toString());
        orderHeaderRequest.setProdutoNome(name);
        orderHeaderRequest.setProdutoDescricao(name);
        orderHeaderRequest.setProdutoValor(value);
        orderHeaderRequest.setCategoriaId(1L);
        orderHeaderRequest.setCategoriaDescricao("Bebida");
        orderHeaderRequest.setCpf("123.456.789-00");
        orderHeaderRequest.setValor(value);
        orderHeaderRequest.setStatusOrdem(status);
        orderHeaderRequest.setPagamentoStatus(status);
        orderHeaderRequest.setPagamentoId(1L);

        GetOrderHeaderRequest orderHeaderRequest2 = new GetOrderHeaderRequest();
        orderHeaderRequest2.setProdutoId(productId.toString());
        orderHeaderRequest2.setProdutoNome(name);
        orderHeaderRequest2.setProdutoDescricao(name);
        orderHeaderRequest2.setProdutoValor(value);
        orderHeaderRequest2.setCategoriaId(1L);
        orderHeaderRequest2.setCategoriaDescricao("Bebida");
        orderHeaderRequest2.setCpf("123.456.789-00");
        orderHeaderRequest2.setValor(value);
        orderHeaderRequest2.setStatusOrdem(status);
        orderHeaderRequest2.setPagamentoStatus(status);
        orderHeaderRequest2.setPagamentoId(1L);

        assertEquals(orderHeaderRequest.hashCode(), orderHeaderRequest2.hashCode());
    }
}


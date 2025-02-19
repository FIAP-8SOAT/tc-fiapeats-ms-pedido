package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetOrderHeaderRequestTest {

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

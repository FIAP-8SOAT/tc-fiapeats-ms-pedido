package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.FeignClientMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindClient;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import br.com.fiap.fiapeats.core.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FeignFindClientPortImplTest {

    @InjectMocks
    private FeignFindClientPortImpl feignFindClientPort;
    @Mock
    private FeignFindClient feignFindClient;
    @Mock
    private FeignClientMapper feignClientMapper;
    private Client client;
    private FeignClientResponse feignClientResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client("Teste", "teste@gmail.com", "12345678901");
        feignClientResponse = new FeignClientResponse("Teste", "teste@gmail.com", "12345678901");
    }

    @Test
    void shouldFindClientWithSuccess() {

        when(feignFindClient.getClient("12345678901", "correlationId")).thenReturn(feignClientResponse);
        when(feignClientMapper.toClientFromFeignClient(any())).thenReturn(client);

        Client response = feignFindClientPort.findClient("12345678901");

        assertNotNull(response);
        assertEquals("Teste", response.getName());
        assertEquals("teste@gmail.com", response.getEmail());
        assertEquals("12345678901", response.getDocument());

        verify(feignFindClient, times(1)).getClient(any(), any());
        verify(feignClientMapper, times(1)).toClientFromFeignClient(any());
    }
}

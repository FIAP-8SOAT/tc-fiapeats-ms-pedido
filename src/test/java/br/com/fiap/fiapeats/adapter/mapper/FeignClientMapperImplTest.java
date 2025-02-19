package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import br.com.fiap.fiapeats.core.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeignClientMapperImplTest {

    private final FeignClientMapperImpl feignClientMapper = new FeignClientMapperImpl();

    @Test
    void toClientFromFeignClient() {
        FeignClientResponse response = new FeignClientResponse();
        response.setName("John Doe");
        response.setEmail("john.doe@example.com");
        response.setDocument("12345678901");

        Client client = feignClientMapper.toClientFromFeignClient(response);

        assertNotNull(client, "O client não deve ser null");
        assertEquals("John Doe", client.getName(), "O nome não foi mapeado corretamente");
        assertEquals("john.doe@example.com", client.getEmail(), "O email não foi mapeado corretamente");
        assertEquals("12345678901", client.getDocument(), "O documento não foi mapeado corretamente");

    }

    @Test
    void testToClientFromFeignClientNull() {
        Client client = feignClientMapper.toClientFromFeignClient(null);

        assertNull(client, "O client deve ser null quando o FeignClientResponse for null");
    }
}

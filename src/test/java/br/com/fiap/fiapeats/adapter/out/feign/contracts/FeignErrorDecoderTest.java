package br.com.fiap.fiapeats.adapter.out.feign.contracts;

import br.com.fiap.fiapeats.adapter.out.feign.FeignErrorDecoder;
import feign.Response;
import jakarta.el.MethodNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeignErrorDecoderTest {

    private FeignErrorDecoder errorDecoder;

    @BeforeEach
    void setUp() {
        errorDecoder = new FeignErrorDecoder();
    }

    private Response.Body createMockEmptyBody() throws IOException {
        ByteArrayInputStream emptyStream = new ByteArrayInputStream(new byte[0]);
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(emptyStream);
        return mockBody;
    }

    @Test
    void testDecode_notFoundStatus_shouldReturnMethodNotFoundException() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(404);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof MethodNotFoundException);
        assertEquals("Erro detalhado", exception.getMessage());
    }

    @Test
    void testDecode_badRequestStatus_shouldReturnIllegalArgumentException() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(400);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("Erro na requisição ao serviço externo.", exception.getMessage());
    }

    @Test
    void testDecode_internalServerErrorStatus_shouldReturnRuntimeException() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(500);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof RuntimeException);
        assertEquals("Erro interno no serviço externo.", exception.getMessage());
    }

    @Test
    void testDecode_unknownStatus_shouldReturnMethodNotFoundExceptionWithMessage() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(502);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof MethodNotFoundException);
        assertTrue(exception.getMessage().contains("Código: 502"));
    }

    @Test
    void testDecode_bodyNotNull_shouldIncludeBodyInExceptionMessage() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(404);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof MethodNotFoundException);
        assertTrue(exception.getMessage().contains(errorBody));
    }

    @Test
    void testDecode_bodyReadError_shouldHandleIOException() throws IOException {
        Response response = mock(Response.class);
        when(response.status()).thenReturn(404);
        String errorBody = "Erro detalhado";
        Response.Body mockBody = mock(Response.Body.class);
        when(mockBody.asInputStream()).thenReturn(new ByteArrayInputStream(errorBody.getBytes(StandardCharsets.UTF_8)));
        when(response.body()).thenReturn(mockBody);

        Exception exception = errorDecoder.decode("methodKey", response);

        assertTrue(exception instanceof MethodNotFoundException);
    }
}

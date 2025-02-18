package br.com.fiap.fiapeats.adapter.exception;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ErrorResponse;
import br.com.fiap.fiapeats.core.exceptions.ClientNotFoundException;
import br.com.fiap.fiapeats.core.exceptions.FillOrderPropertiesException;
import br.com.fiap.fiapeats.core.exceptions.OrderNotFoundException;
import br.com.fiap.fiapeats.core.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GlobalExceptionHandlingTest {

    @InjectMocks
    private GlobalExceptionHandling globalExceptionHandling;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleClientNotFoundException() {
        ClientNotFoundException exception = new ClientNotFoundException("O cliente informado não consta cadastro");

        ErrorResponse response = globalExceptionHandling.handleClientNotFoundException(exception);

        assertNotNull(response);
        assertEquals(response.getErrorCode(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertEquals(response.getErrorName(), HttpStatus.UNPROCESSABLE_ENTITY.name());
        assertEquals(response.getMessage(), "O cliente informado não consta cadastro");
    }

    @Test
    void handleFillOrderException() {
        FillOrderPropertiesException exception = new FillOrderPropertiesException("Erro inesperado");
        ErrorResponse response = globalExceptionHandling.handleFillOrderException(exception);

        assertNotNull(response);
        assertEquals(response.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertEquals(response.getErrorName(), HttpStatus.INTERNAL_SERVER_ERROR.name());
        assertEquals(response.getMessage(), "Erro inesperado");
    }

    @Test
    void handleProductNotFoundException() {
        ProductNotFoundException exception = new ProductNotFoundException("Existem produtos na lista que não estão na base");
        ErrorResponse response = globalExceptionHandling.handleProductNotFoundException(exception);

        assertNotNull(response);
        assertEquals(response.getErrorCode(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertEquals(response.getErrorName(), HttpStatus.UNPROCESSABLE_ENTITY.name());
        assertEquals(response.getMessage(), "Existem produtos na lista que não estão na base");
    }

    @Test
    void handleOrderNotFoundException() {
        OrderNotFoundException exception = new OrderNotFoundException("Ordem %s não existe na base");
        ErrorResponse response = globalExceptionHandling.handleOrderNotFoundException(exception);

        assertNotNull(response);
        assertEquals(response.getErrorCode(), HttpStatus.NOT_FOUND.value());
        assertEquals(response.getErrorName(), HttpStatus.NOT_FOUND.name());
        assertEquals(response.getMessage(), "Ordem %s não existe na base");
    }
}

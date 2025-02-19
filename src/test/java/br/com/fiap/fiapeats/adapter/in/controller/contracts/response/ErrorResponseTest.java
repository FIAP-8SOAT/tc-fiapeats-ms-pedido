package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorResponseTest {

    @Test
    void testConstructorAndGetters() {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorName("Not Found")
                .errorCode(404)
                .message("Resource not found")
                .build();

        assertNotNull(errorResponse.getTimestamp());
        assertEquals("Not Found", errorResponse.getErrorName());
        assertEquals(404, errorResponse.getErrorCode());
        assertEquals("Resource not found", errorResponse.getMessage());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        ErrorResponse response = ErrorResponse.builder()
                .errorName("erro")
                .errorCode(404)
                .message("erro")
                .build();

        ErrorResponse response2 = ErrorResponse.builder()
                .errorName("erro")
                .errorCode(400)
                .message("erro")
                .build();

        assertNotEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        ErrorResponse response = ErrorResponse.builder()
                .errorName("erro")
                .errorCode(404)
                .message("erro")
                .build();

        ErrorResponse response2 = ErrorResponse.builder()
                .errorName("erro")
                .errorCode(400)
                .message("erro")
                .build();

        assertNotEquals(response.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorName("Unauthorized")
                .errorCode(401)
                .message("Authentication required")
                .build();

        String expectedString = "ErrorResponse(timestamp=" + errorResponse.getTimestamp() +
                ", errorName=Unauthorized, errorCode=401, message=Authentication required)";

        assertTrue(errorResponse.toString().contains("Unauthorized"));
        assertTrue(errorResponse.toString().contains("401"));
        assertTrue(errorResponse.toString().contains("Authentication required"));
    }
}

package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ErrorResponseTest {

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
}

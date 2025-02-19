package br.com.fiap.fiapeats.adapter.out.feign.contracts.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeignClientResponseTest {

    @Test
    void testToString() {
        String name = "Maria";
        String document = "12345678901";
        String email = "maria@gmail.com";

        FeignClientResponse response = FeignClientResponse.builder().build();
        response.setName(name);
        response.setEmail(email);
        response.setDocument(document);

        String expectedString = "FeignClientResponse(" +
                "name=Maria" +
                ", email=maria@gmail.com" +
                ", document=12345678901" +
                ')';

        assertEquals(expectedString, response.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        String name = "Maria";
        String document = "12345678901";
        String email = "maria@gmail.com";

        FeignClientResponse response = FeignClientResponse.builder().build();
        response.setName(name);
        response.setEmail(email);
        response.setDocument(document);

        FeignClientResponse response2 = FeignClientResponse.builder().build();
        response2.setName(name);
        response2.setEmail(email);
        response2.setDocument(document);

        assertEquals(response, response2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        String name = "Maria";
        String document = "12345678901";
        String email = "maria@gmail.com";

        FeignClientResponse response = FeignClientResponse.builder().build();
        response.setName(name);
        response.setEmail(email);
        response.setDocument(document);

        FeignClientResponse response2 = FeignClientResponse.builder().build();
        response2.setName(name);
        response2.setEmail(email);
        response2.setDocument(document);

        assertEquals(response.hashCode(), response2.hashCode());
    }
}

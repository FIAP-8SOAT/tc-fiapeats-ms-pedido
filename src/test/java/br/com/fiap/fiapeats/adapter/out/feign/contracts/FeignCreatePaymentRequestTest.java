package br.com.fiap.fiapeats.adapter.out.feign.contracts;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignProducItemPaymentRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FeignCreatePaymentRequestTest {

    @Test
    void testFeignCreatePaymentRequestBuilder() {
        String orderId = "order-12345";
        FeignProducItemPaymentRequest product = new FeignProducItemPaymentRequest(UUID.randomUUID(), "product-1", "produto", BigDecimal.TEN, "Bebida");

        FeignCreatePaymentRequest request = FeignCreatePaymentRequest.builder()
                .orderId(orderId)
                .products(Arrays.asList(product))
                .build();

        assertEquals(orderId, request.getOrderId());
        assertNotNull(request.getProducts());
        assertEquals(1, request.getProducts().size());
        assertEquals(product, request.getProducts().get(0));
    }
}

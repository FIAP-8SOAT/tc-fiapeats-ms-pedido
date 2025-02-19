package br.com.fiap.fiapeats.adapter.out.feign.contracts.requests;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignProducItemPaymentRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        String name = "product";
        BigDecimal value = new BigDecimal(100);
        String category = "Bebida";

        FeignProducItemPaymentRequest feignProducItemPaymentRequest = new FeignProducItemPaymentRequest();
        feignProducItemPaymentRequest.setId(id);
        feignProducItemPaymentRequest.setName(name);
        feignProducItemPaymentRequest.setDescription(name);
        feignProducItemPaymentRequest.setValue(value);
        feignProducItemPaymentRequest.setCategory(category);

        FeignCreatePaymentRequest feignCreatePaymentRequest = FeignCreatePaymentRequest.builder().build();
        feignCreatePaymentRequest.setOrderId(id.toString());
        feignCreatePaymentRequest.setProducts(List.of(feignProducItemPaymentRequest));

        String expectedString = "FeignCreatePaymentRequest(" +
                "orderId=" + id +
                ", products=" + List.of(feignProducItemPaymentRequest) +
                ')';

        assertEquals(expectedString, feignCreatePaymentRequest.toString());
    }

    @Test
    void testEquals_sameValues_shouldReturnTrue() {
        UUID id = UUID.randomUUID();
        String name = "product";
        BigDecimal value = new BigDecimal(100);
        String category = "Bebida";

        FeignProducItemPaymentRequest feignProducItemPaymentRequest = new FeignProducItemPaymentRequest();
        feignProducItemPaymentRequest.setId(id);
        feignProducItemPaymentRequest.setName(name);
        feignProducItemPaymentRequest.setDescription(name);
        feignProducItemPaymentRequest.setValue(value);
        feignProducItemPaymentRequest.setCategory(category);

        FeignCreatePaymentRequest feignCreatePaymentRequest = FeignCreatePaymentRequest.builder().build();
        feignCreatePaymentRequest.setOrderId(id.toString());
        feignCreatePaymentRequest.setProducts(List.of(feignProducItemPaymentRequest));

        FeignCreatePaymentRequest feignCreatePaymentRequest2 = FeignCreatePaymentRequest.builder().build();
        feignCreatePaymentRequest2.setOrderId(id.toString());
        feignCreatePaymentRequest2.setProducts(List.of(feignProducItemPaymentRequest));

        assertEquals(feignCreatePaymentRequest, feignCreatePaymentRequest2);
    }

    @Test
    void testHashCode_sameValues_shouldReturnSameHashCode() {
        UUID id = UUID.randomUUID();
        String name = "product";
        BigDecimal value = new BigDecimal(100);
        String category = "Bebida";

        FeignProducItemPaymentRequest feignProducItemPaymentRequest = new FeignProducItemPaymentRequest();
        feignProducItemPaymentRequest.setId(id);
        feignProducItemPaymentRequest.setName(name);
        feignProducItemPaymentRequest.setDescription(name);
        feignProducItemPaymentRequest.setValue(value);
        feignProducItemPaymentRequest.setCategory(category);

        FeignCreatePaymentRequest feignCreatePaymentRequest = new FeignCreatePaymentRequest();
        feignCreatePaymentRequest.setOrderId(id.toString());
        feignCreatePaymentRequest.setProducts(List.of(feignProducItemPaymentRequest));

        FeignCreatePaymentRequest feignCreatePaymentRequest2 = new FeignCreatePaymentRequest();
        feignCreatePaymentRequest2.setOrderId(id.toString());
        feignCreatePaymentRequest2.setProducts(List.of(feignProducItemPaymentRequest));

        assertEquals(feignCreatePaymentRequest.hashCode(), feignCreatePaymentRequest2.hashCode());
    }
}

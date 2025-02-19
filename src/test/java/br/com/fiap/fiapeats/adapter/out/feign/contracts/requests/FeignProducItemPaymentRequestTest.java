package br.com.fiap.fiapeats.adapter.out.feign.contracts.requests;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignProducItemPaymentRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeignProducItemPaymentRequestTest {

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

        String expectedString = "FeignProducItemPaymentRequest(" +
                "id=" + id +
                ", name=product" +
                ", description=product" +
                ", value=100" +
                ", category=Bebida" +
                ')';

        assertEquals(expectedString, feignProducItemPaymentRequest.toString());
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

        FeignProducItemPaymentRequest feignProducItemPaymentRequest2 = new FeignProducItemPaymentRequest();
        feignProducItemPaymentRequest2.setId(id);
        feignProducItemPaymentRequest2.setName(name);
        feignProducItemPaymentRequest2.setDescription(name);
        feignProducItemPaymentRequest2.setValue(value);
        feignProducItemPaymentRequest2.setCategory(category);

        assertEquals(feignProducItemPaymentRequest, feignProducItemPaymentRequest2);
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

        FeignProducItemPaymentRequest feignProducItemPaymentRequest2 = new FeignProducItemPaymentRequest();
        feignProducItemPaymentRequest2.setId(id);
        feignProducItemPaymentRequest2.setName(name);
        feignProducItemPaymentRequest2.setDescription(name);
        feignProducItemPaymentRequest2.setValue(value);
        feignProducItemPaymentRequest2.setCategory(category);

        assertEquals(feignProducItemPaymentRequest.hashCode(), feignProducItemPaymentRequest2.hashCode());
    }
}

package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignCreatePaymentRequest;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.request.FeignProducItemPaymentRequest;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.PaymentGenerateQrCode;
import br.com.fiap.fiapeats.core.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FeignPaymentMapperTest {

    private final FeignPaymentMapper feignPaymentMapper = new FeignPaymentMapperImpl();

    @Test
    void testToFeignPaymentRequestFromPaymentGenerateQrCode() {
        Product product  = new Product(UUID.randomUUID(), "produto", "produto", BigDecimal.TEN, new Category(1L, "Bebida"), null);

        PaymentGenerateQrCode paymentGenerateQrCode = new PaymentGenerateQrCode("123456", List.of(product));

        FeignCreatePaymentRequest result = feignPaymentMapper.toFeignPaymentRequestFromPaymentGenerateQrCode(paymentGenerateQrCode);

        assertNotNull(result, "FeignCreatePaymentRequest não deve ser nulo");
        assertEquals("123456", result.getOrderId(), "OrderId não foi mapeado corretamente");

        assertNotNull(result.getProducts(), "A lista de produtos não deve ser nula");
        assertEquals(1, result.getProducts().size(), "A lista de produtos deveria ter 1 produto");
        FeignProducItemPaymentRequest feignProduct = result.getProducts().get(0);
        assertEquals("produto", feignProduct.getName(), "O nome do produto não foi mapeado corretamente");
        assertEquals("produto", feignProduct.getDescription(), "A descrição do produto não foi mapeada corretamente");
    }

    @Test
    void testToFeignProductItemFromProduct() {
        Product product  = new Product(UUID.randomUUID(), "produto", "produto", BigDecimal.TEN, new Category(1L, "Bebida"), null);

        FeignProducItemPaymentRequest result = feignPaymentMapper.toFeignProductItemFromProduct(product);

        assertNotNull(result, "FeignProducItemPaymentRequest não deve ser nulo");
        assertEquals("produto", result.getName(), "O nome do produto não foi mapeado corretamente");
        assertEquals("produto", result.getDescription(), "A descrição do produto não foi mapeada corretamente");
        assertEquals("Bebida", result.getCategory(), "A categoria do produto não foi mapeada corretamente");
    }
}

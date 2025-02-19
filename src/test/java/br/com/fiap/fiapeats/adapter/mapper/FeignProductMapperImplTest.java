package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsCategoryResponse;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import br.com.fiap.fiapeats.core.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FeignProductMapperTest {

    private final FeignProductMapper feignProductMapper = new FeignProductMapperImpl();

    @Test
    void testToProductFromFeignProduct() {
        // Criando Category mock
        FeignFindProductsCategoryResponse categoryResponse = new FeignFindProductsCategoryResponse();
        categoryResponse.setId("1");
        categoryResponse.setDescription("Categoria Teste");

        // Criando FeignFindProductsResponse mock
        FeignFindProductsResponse response = new FeignFindProductsResponse();
        response.setId("d7bdee3b-d74f-477d-b2a4-8db45e6fdb45");
        response.setName("Produto Teste");
        response.setDescription("Descrição do Produto Teste");
        response.setValue(BigDecimal.valueOf(200.50));
        response.setCategory(categoryResponse);
        response.setImageUrl("http://example.com/image.jpg");

        // Chamando o método
        Product product = feignProductMapper.toProductFromFeignProduct(response);

        // Verificando se o resultado não é nulo
        assertNotNull(product, "Product não deve ser nulo");
        assertEquals(UUID.fromString("d7bdee3b-d74f-477d-b2a4-8db45e6fdb45"), product.getId(), "ID do produto não foi mapeado corretamente");
        assertEquals("Produto Teste", product.getName(), "Nome do produto não foi mapeado corretamente");
        assertEquals("Descrição do Produto Teste", product.getDescription(), "Descrição do produto não foi mapeada corretamente");
        assertEquals(BigDecimal.valueOf(200.50), product.getValue(), "Valor do produto não foi mapeado corretamente");
        assertNotNull(product.getCategory(), "Categoria do produto não deve ser nula");
        assertEquals(Long.valueOf(1), product.getCategory().getId(), "ID da categoria não foi mapeado corretamente");
        assertEquals("Categoria Teste", product.getCategory().getDescription(), "Descrição da categoria não foi mapeada corretamente");
    }

    @Test
    void testToProductListFromFeignProductList() {
        // Criando uma lista de FeignFindProductsResponse mock
        FeignFindProductsCategoryResponse categoryResponse = new FeignFindProductsCategoryResponse();
        categoryResponse.setId("1");
        categoryResponse.setDescription("Categoria Teste");

        FeignFindProductsResponse response1 = new FeignFindProductsResponse();
        response1.setId("d7bdee3b-d74f-477d-b2a4-8db45e6fdb45");
        response1.setName("Produto 1");
        response1.setDescription("Descrição do Produto 1");
        response1.setValue(BigDecimal.valueOf(150));
        response1.setCategory(categoryResponse);
        response1.setImageUrl("http://example.com/image1.jpg");

        FeignFindProductsResponse response2 = new FeignFindProductsResponse();
        response2.setId("5b4ae2cb-1ac3-4d8f-bfd8-6ac3426b6f7d");
        response2.setName("Produto 2");
        response2.setDescription("Descrição do Produto 2");
        response2.setValue(BigDecimal.valueOf(250));
        response2.setCategory(categoryResponse);
        response2.setImageUrl("http://example.com/image2.jpg");

        List<FeignFindProductsResponse> responses = Arrays.asList(response1, response2);

        // Chamando o método
        List<Product> products = feignProductMapper.toProductListFromFeignProductList(responses);

        // Verificando se o resultado não é nulo
        assertNotNull(products, "A lista de produtos não deve ser nula");
        assertEquals(2, products.size(), "A lista de produtos deveria ter 2 produtos");

        // Verificando o conteúdo da lista
        Product product1 = products.get(0);
        assertEquals("Produto 1", product1.getName(), "Nome do primeiro produto não foi mapeado corretamente");

        Product product2 = products.get(1);
        assertEquals("Produto 2", product2.getName(), "Nome do segundo produto não foi mapeado corretamente");
    }

    @Test
    void testToProductFromFeignProductWhenNull() {
        // Chamando o método com um valor nulo
        Product product = feignProductMapper.toProductFromFeignProduct(null);

        // Verificando se o resultado é nulo
        assertNull(product, "Product deve ser nulo");
    }
}


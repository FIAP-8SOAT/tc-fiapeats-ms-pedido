package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.FeignProductMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindProducts;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsCategoryResponse;
import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import br.com.fiap.fiapeats.core.domain.Category;
import br.com.fiap.fiapeats.core.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FeignFindProductPortImplTest {

    @InjectMocks
    private FeignFindProductPortImpl feignFindProductPort;
    @Mock
    private FeignFindProducts feignFindProducts;
    @Mock
    private FeignProductMapper feignProductMapper;
    private Product product;
    private FeignFindProductsResponse feignFindProductsResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product(UUID.randomUUID(), "Produto", "Produto Teste", BigDecimal.TEN, new Category(1L, "Bebida"), null);
        feignFindProductsResponse = new FeignFindProductsResponse(UUID.randomUUID().toString(), "Produto", "Produto Teste", BigDecimal.TEN, FeignFindProductsCategoryResponse.builder().id(UUID.randomUUID().toString()).description("Bebida").build(), null);
    }

    @Test
    void shouldGetAllProductsWithSuccess() {

        when(feignFindProducts.getAllProducts(any())).thenReturn(List.of(feignFindProductsResponse));
        when(feignProductMapper.toProductListFromFeignProductList(any())).thenReturn(List.of(product));

        List<Product> response = feignFindProductPort.getAllProducts();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("Produto", response.get(0).getName());
        assertEquals("Produto Teste", response.get(0).getDescription());
        assertEquals(BigDecimal.TEN, response.get(0).getValue());
        assertEquals("Bebida", response.get(0).getCategory().getDescription());
        assertNull(response.get(0).getImageUrl());

        verify(feignFindProducts, times(1)).getAllProducts(any());
        verify(feignProductMapper, times(1)).toProductListFromFeignProductList(any());
    }
}

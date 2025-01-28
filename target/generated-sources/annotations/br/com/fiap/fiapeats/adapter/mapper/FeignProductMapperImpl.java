package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignFindProductsResponse;
import br.com.fiap.fiapeats.core.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-28T17:15:13-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class FeignProductMapperImpl implements FeignProductMapper {

    @Override
    public Product toProductFromFeignProduct(FeignFindProductsResponse response) {
        if ( response == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( FeignProductMapper.mapCategory( response.getCategory() ) );
        product.setId( response.getId() );
        product.setName( response.getName() );
        product.setDescription( response.getDescription() );
        product.setValue( response.getValue() );
        product.setImageUrl( response.getImageUrl() );

        return product;
    }

    @Override
    public List<Product> toProductListFromFeignProductList(List<FeignFindProductsResponse> responses) {
        if ( responses == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( responses.size() );
        for ( FeignFindProductsResponse feignFindProductsResponse : responses ) {
            list.add( toProductFromFeignProduct( feignFindProductsResponse ) );
        }

        return list;
    }
}

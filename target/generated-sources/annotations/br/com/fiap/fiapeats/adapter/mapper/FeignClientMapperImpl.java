package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import br.com.fiap.fiapeats.core.domain.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T16:08:11-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class FeignClientMapperImpl implements FeignClientMapper {

    @Override
    public Client toClientFromFeignClient(FeignClientResponse response) {
        if ( response == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String document = null;

        name = response.getName();
        email = response.getEmail();
        document = response.getDocument();

        Client client = new Client( name, email, document );

        return client;
    }
}

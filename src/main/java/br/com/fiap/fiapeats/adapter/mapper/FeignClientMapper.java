package br.com.fiap.fiapeats.adapter.mapper;

import br.com.fiap.fiapeats.adapter.out.feign.contracts.response.FeignClientResponse;
import br.com.fiap.fiapeats.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeignClientMapper {

  Client toClientFromFeignClient(FeignClientResponse response);
}

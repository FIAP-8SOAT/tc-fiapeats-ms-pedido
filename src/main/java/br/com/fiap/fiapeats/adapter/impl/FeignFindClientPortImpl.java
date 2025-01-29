package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.mapper.FeignClientMapper;
import br.com.fiap.fiapeats.adapter.out.feign.FeignFindClient;
import br.com.fiap.fiapeats.core.domain.Client;
import br.com.fiap.fiapeats.core.ports.out.FeignFindClientPort;

public class FeignFindClientPortImpl implements FeignFindClientPort {

  private final FeignFindClient feignFindClient;
  private final FeignClientMapper feignClientMapper;

  public FeignFindClientPortImpl(
      FeignFindClient feignFindClient, FeignClientMapper feignClientMapper) {
    this.feignFindClient = feignFindClient;
    this.feignClientMapper = feignClientMapper;
  }

  @Override
  public Client findClient(String document) {
    return feignClientMapper.toClientFromFeignClient(feignFindClient.getClient(document));
  }
}

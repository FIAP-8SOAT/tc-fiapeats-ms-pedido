package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Client;

public interface FeignFindClientPort {

  Client findClient(String document);
}

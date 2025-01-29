package br.com.fiap.fiapeats.adapter.out.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    HttpStatus status = HttpStatus.valueOf(response.status());
    try {
      if (response.body() != null) {
        String body =
            new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return switch (status) {
      case NOT_FOUND -> new NotFoundException("Cliente não encontrado!");
      case BAD_REQUEST -> new IllegalArgumentException("Erro na requisição ao serviço externo.");
      case INTERNAL_SERVER_ERROR -> new RuntimeException("Erro interno no serviço externo.");
      default -> new NotFoundException(
          "Erro desconhecido no Feign Client. Código: " + response.status());
    };
  }
}

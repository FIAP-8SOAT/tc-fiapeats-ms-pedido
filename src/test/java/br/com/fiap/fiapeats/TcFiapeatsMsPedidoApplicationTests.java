package br.com.fiap.fiapeats;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(
    properties = {
      "DATASOURCE_USERNAME=admin",
      "DATASOURCE_PASSWORD=pass",
      "DATASOURCE_HOST=localhost",
      "DATASOURCE_PORT=27017",
      "DATASOURCE=localhost",
      "DATASOURCE_AUTH=admin",
      "FEIGN_BASE_URL=http://localhost:8080/fiapeats"
    })
class TcFiapeatsMsPedidoApplicationTests {

  @Test
  void contextLoads() {}
}

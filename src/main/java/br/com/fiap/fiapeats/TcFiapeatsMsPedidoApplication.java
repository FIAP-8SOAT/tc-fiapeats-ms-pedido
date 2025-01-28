package br.com.fiap.fiapeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TcFiapeatsMsPedidoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TcFiapeatsMsPedidoApplication.class, args);
  }
}

package br.com.fiap.fiapeats.core.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OrderNotFoundExceptionTest {

  @Test
  void shouldCreateExceptionWithMessage() {
    String expectedMessage = "Pedido não encontrado";

    OrderNotFoundException exception = new OrderNotFoundException(expectedMessage);

    assertThat(exception.getMessage()).isEqualTo(expectedMessage);
  }

  @Test
  void shouldThrowExceptionWithMessage() {
    String expectedMessage = "O pedido informado não existe";

    Exception thrownException =
        assertThrows(
            OrderNotFoundException.class,
            () -> {
              throw new OrderNotFoundException(expectedMessage);
            });

    assertThat(thrownException.getMessage()).isEqualTo(expectedMessage);
  }
}

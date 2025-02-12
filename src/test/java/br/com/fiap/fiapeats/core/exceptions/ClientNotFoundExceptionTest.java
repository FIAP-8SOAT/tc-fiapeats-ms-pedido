package br.com.fiap.fiapeats.core.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ClientNotFoundExceptionTest {

  @Test
  void shouldCreateExceptionWithMessage() {
    String expectedMessage = "O cliente não foi encontrado";

    ClientNotFoundException exception = new ClientNotFoundException(expectedMessage);

    assertThat(exception.getMessage()).isEqualTo(expectedMessage);
  }

  @Test
  void shouldThrowExceptionWithMessage() {
    String expectedMessage = "Cliente não existe";

    Exception thrownException =
        assertThrows(
            ClientNotFoundException.class,
            () -> {
              throw new ClientNotFoundException(expectedMessage);
            });

    assertThat(thrownException.getMessage()).isEqualTo(expectedMessage);
  }
}

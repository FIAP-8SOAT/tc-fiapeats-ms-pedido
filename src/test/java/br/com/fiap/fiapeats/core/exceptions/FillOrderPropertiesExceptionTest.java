package br.com.fiap.fiapeats.core.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FillOrderPropertiesExceptionTest {

  @Test
  void shouldCreateExceptionWithMessage() {
    String expectedMessage = "Erro ao preencher propriedades do pedido";

    FillOrderPropertiesException exception = new FillOrderPropertiesException(expectedMessage);

    assertThat(exception.getMessage()).isEqualTo(expectedMessage);
  }

  @Test
  void shouldThrowExceptionWithMessage() {
    String expectedMessage = "Campos obrigatórios ausentes no pedido";

    Exception thrownException =
        assertThrows(
            FillOrderPropertiesException.class,
            () -> {
              throw new FillOrderPropertiesException(expectedMessage);
            });

    assertThat(thrownException.getMessage()).isEqualTo(expectedMessage);
  }
}

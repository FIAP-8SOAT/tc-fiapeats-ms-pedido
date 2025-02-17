package br.com.fiap.fiapeats.core.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProductNotFoundExceptionTest {

  @Test
  void shouldCreateExceptionWithMessage() {
    String expectedMessage = "Produto não encontrado";

    ProductNotFoundException exception = new ProductNotFoundException(expectedMessage);

    assertThat(exception.getMessage()).isEqualTo(expectedMessage);
  }

  @Test
  void shouldThrowExceptionWithMessage() {
    String expectedMessage = "O produto informado não existe";

    Exception thrownException =
        assertThrows(
            ProductNotFoundException.class,
            () -> {
              throw new ProductNotFoundException(expectedMessage);
            });

    assertThat(thrownException.getMessage()).isEqualTo(expectedMessage);
  }
}

package br.com.fiap.fiapeats.core.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class ConstantsTest {

  @Test
  void shouldHaveCorrectConstantValues() {
    assertThat(Constants.CORRELATION_ID).isEqualTo("correlation_id");
    assertThat(Constants.PENDING).isEqualTo("Pendente");
    assertThat(Constants.TXT_PRODUCT_NOT_FOUND)
        .isEqualTo("Existem produtos na lista que não estão na base");
    assertThat(Constants.TXT_CLIENT_NOT_FOUND).isEqualTo("O cliente informado não consta cadastro");
  }

  @Test
  void shouldNotAllowInstantiation() throws Exception {
    Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    assertThrows(InvocationTargetException.class, constructor::newInstance);
  }
}

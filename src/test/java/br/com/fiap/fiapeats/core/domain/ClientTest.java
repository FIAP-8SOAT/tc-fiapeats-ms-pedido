package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ClientTest {

  @Test
  void shouldCreateClientWithNameEmailAndDocument() {
    String name = "John Doe";
    String email = "johndoe@example.com";
    String document = "123.456.789-00";
    Client client = new Client(name, email, document);
    assertThat(client.getName()).isEqualTo(name);
    assertThat(client.getEmail()).isEqualTo(email);
    assertThat(client.getDocument()).isEqualTo(document);
  }

  @Test
  void shouldUpdateClientName() {
    Client client = new Client("John Doe", "johndoe@example.com", "123.456.789-00");
    String newName = "Jane Doe";
    client.setName(newName);
    assertThat(client.getName()).isEqualTo(newName);
  }

  @Test
  void shouldUpdateClientEmail() {
    Client client = new Client("John Doe", "johndoe@example.com", "123.456.789-00");
    String newEmail = "janedoe@example.com";
    client.setEmail(newEmail);
    assertThat(client.getEmail()).isEqualTo(newEmail);
  }

  @Test
  void shouldUpdateClientDocument() {
    Client client = new Client("John Doe", "johndoe@example.com", "123.456.789-00");
    String newDocument = "987.654.321-00";
    client.setDocument(newDocument);
    assertThat(client.getDocument()).isEqualTo(newDocument);
  }

  @Test
  void shouldHaveCorrectToString() {
    Client client = new Client("John Doe", "johndoe@example.com", "123.456.789-00");
    String result = client.toString();
    assertThat(result)
        .contains("name='John Doe'", "email='johndoe@example.com'", "document='123.456.789-00'");
  }
}

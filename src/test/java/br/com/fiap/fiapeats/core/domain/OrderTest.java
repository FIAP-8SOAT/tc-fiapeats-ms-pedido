package br.com.fiap.fiapeats.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

  private Order order;
  private UUID id;
  private List<Product> products;
  private String taxId;
  private BigDecimal value;
  private String orderStatus;
  private String paymentStatus;
  private LocalDateTime createTimestamp;
  private Long paymentId;
  private int timeWaiting;
  private String qrCode;

  @BeforeEach
  void setUp() {
    id = UUID.randomUUID();
    products =
        Arrays.asList(
            new Product(
                UUID.randomUUID(),
                "Pizza",
                "Delicious pizza",
                BigDecimal.valueOf(39.99),
                null,
                "pizza.jpg"),
            new Product(
                UUID.randomUUID(),
                "Burger",
                "Juicy burger",
                BigDecimal.valueOf(19.99),
                null,
                "burger.jpg"));
    taxId = "123.456.789-00";
    value = BigDecimal.valueOf(59.98);
    orderStatus = "CONFIRMED";
    paymentStatus = "PAID";
    createTimestamp = LocalDateTime.now();
    paymentId = 1L;
    timeWaiting = 15;
    qrCode = "QR123ABC";

    order =
        new Order(
            id,
            products,
            taxId,
            value,
            orderStatus,
            paymentStatus,
            paymentId,
            createTimestamp,
            timeWaiting,
            qrCode);
  }

  @Test
  void shouldCreateOrderWithAllFields() {
    assertThat(order.getId()).isEqualTo(id);
    assertThat(order.getProducts()).isEqualTo(products);
    assertThat(order.getTaxId()).isEqualTo(taxId);
    assertThat(order.getValue()).isEqualTo(value);
    assertThat(order.getOrderStatus()).isEqualTo(orderStatus);
    assertThat(order.getPaymentStatus()).isEqualTo(paymentStatus);
    assertThat(order.getCreateTimestamp()).isEqualTo(createTimestamp);
    assertThat(order.getTimeWaiting()).isEqualTo(timeWaiting);
    assertThat(order.getQrCode()).isEqualTo(qrCode);
    assertThat(order.getPaymentId()).isEqualTo(paymentId);
  }

  @Test
  void shouldUpdateOrderId() {
    UUID newId = UUID.randomUUID();
    order.setId(newId);
    assertThat(order.getId()).isEqualTo(newId);
  }

  @Test
  void shouldUpdateProductsList() {
    List<Product> newProducts =
        Arrays.asList(
            new Product(
                UUID.randomUUID(),
                "Sushi",
                "Fresh sushi",
                BigDecimal.valueOf(29.99),
                null,
                "sushi.jpg"));
    order.setProducts(newProducts);
    assertThat(order.getProducts()).isEqualTo(newProducts);
  }

  @Test
  void shouldUpdateTaxId() {
    String newTaxId = "987.654.321-00";
    order.setTaxId(newTaxId);
    assertThat(order.getTaxId()).isEqualTo(newTaxId);
  }

  @Test
  void shouldUpdateValue() {
    BigDecimal newValue = BigDecimal.valueOf(79.99);
    order.setValue(newValue);
    assertThat(order.getValue()).isEqualTo(newValue);
  }

  @Test
  void shouldUpdateOrderStatus() {
    String newStatus = "SHIPPED";
    order.setOrderStatus(newStatus);
    assertThat(order.getOrderStatus()).isEqualTo(newStatus);
  }

  @Test
  void shouldUpdatePaymentStatus() {
    String newPaymentStatus = "PENDING";
    order.setPaymentStatus(newPaymentStatus);
    assertThat(order.getPaymentStatus()).isEqualTo(newPaymentStatus);
  }

  @Test
  void shouldUpdateCreateTimestamp() {
    LocalDateTime newTimestamp = LocalDateTime.now().plusDays(1);
    order.setCreateTimestamp(newTimestamp);
    assertThat(order.getCreateTimestamp()).isEqualTo(newTimestamp);
  }

  @Test
  void shouldUpdateTimeWaiting() {
    int newTimeWaiting = 30;
    order.setTimeWaiting(newTimeWaiting);
    assertThat(order.getTimeWaiting()).isEqualTo(newTimeWaiting);
  }

  @Test
  void shouldUpdateQrCode() {
    String newQrCode = "NEW_QR_CODE_456";
    order.setQrCode(newQrCode);
    assertThat(order.getQrCode()).isEqualTo(newQrCode);
  }

  @Test
  void shouldHaveCorrectToString() {
    String result = order.toString();
    assertThat(result)
        .contains(
            "id=" + id,
            "products=" + products.toString(),
            "taxId='" + taxId + "'",
            "value=" + value,
            "qrCode='" + qrCode + "'",
            "orderStatus='" + orderStatus + "'",
            "paymentStatus='" + paymentStatus + "'",
            "createTimestamp=" + createTimestamp,
            "timeWaiting=" + timeWaiting);
  }
}

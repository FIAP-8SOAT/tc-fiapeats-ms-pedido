package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

  private UUID id;
  private List<Product> products;
  private String taxId;
  private BigDecimal value;
  private Long idStatus;
  private LocalDateTime createTimestamp;
  private int timeWaiting;

  public Order(
      UUID id,
      List<Product> products,
      String taxId,
      BigDecimal value,
      Long idStatus,
      LocalDateTime createTimestamp,
      int timeWaiting) {
    this.id = id;
    this.products = products;
    this.taxId = taxId;
    this.value = value;
    this.idStatus = idStatus;
    this.createTimestamp = createTimestamp;
    this.timeWaiting = timeWaiting;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public String getTaxId() {
    return taxId;
  }

  public void setTaxId(String taxId) {
    this.taxId = taxId;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public Long getIdStatus() {
    return idStatus;
  }

  public void setIdStatus(Long idStatus) {
    this.idStatus = idStatus;
  }

  public LocalDateTime getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(LocalDateTime createTimestamp) {
    this.createTimestamp = createTimestamp;
  }

  public int getTimeWaiting() {
    return timeWaiting;
  }

  public void setTimeWaiting(int timeWaiting) {
    this.timeWaiting = timeWaiting;
  }
}

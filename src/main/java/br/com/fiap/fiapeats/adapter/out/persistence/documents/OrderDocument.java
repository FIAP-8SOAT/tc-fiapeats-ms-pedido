package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "orders")
@Data
public class OrderDocument implements Serializable {

  @Id private String id;

  @Field("products")
  private List<ProductDocument> products;

  private String taxId;
  private BigDecimal value;
  private Long idStatus;
  private LocalDateTime createTimestamp;
  private int timeWaiting;
}

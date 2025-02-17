package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import br.com.fiap.fiapeats.core.domain.Category;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "products")
public class ProductDocument implements Serializable {
  @Id private String id;
  private String name;
  private String description;
  private BigDecimal value;
  private Category category;
  private String imageUrl;
}

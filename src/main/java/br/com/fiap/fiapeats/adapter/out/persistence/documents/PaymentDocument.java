package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
@Data
public class PaymentDocument implements Serializable {
  private Long paymentId;
  private String paymentStatus;
  private String qrCode;
}

package br.com.fiap.fiapeats.adapter.out.persistence.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "payment")
@Data
public class PaymentDocument implements Serializable {
  private Long paymentId;
  private String paymentStatus;
  private String qrCode;
}

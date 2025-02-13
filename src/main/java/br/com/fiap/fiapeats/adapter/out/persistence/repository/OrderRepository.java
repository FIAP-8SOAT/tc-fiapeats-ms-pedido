package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderDocument, String> {}

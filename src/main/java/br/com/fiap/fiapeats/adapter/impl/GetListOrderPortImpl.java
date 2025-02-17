package br.com.fiap.fiapeats.adapter.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.documents.OrderDocument;
import br.com.fiap.fiapeats.core.ports.out.GetListOrderPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class GetListOrderPortImpl implements GetListOrderPort {

  private final MongoTemplate mongoTemplate;

  private final OrderMapper orderMapper;

  public GetListOrderPortImpl(MongoTemplate mongoTemplate, OrderMapper orderMapper) {
    this.mongoTemplate = mongoTemplate;
    this.orderMapper = orderMapper;
  }

  @Override
  public OrderDocument getOrderByHeaders(GetOrderHeaderRequest request) {
    Query query = new Query();
    Criteria criteria = new Criteria();

    if (request.getProdutoId() != null) {
      criteria.orOperator(Criteria.where("products._id").is(request.getProdutoId().toString()));
    }
    if (request.getProdutoNome() != null) {
      criteria.orOperator(Criteria.where("products.name").regex(request.getProdutoNome(), "i"));
    }
    if (request.getProdutoDescricao() != null) {
      criteria.orOperator(
          Criteria.where("products.description").regex(request.getProdutoDescricao(), "i"));
    }
    if (request.getProdutoValor() != null) {
      criteria.orOperator(Criteria.where("products.value").is(request.getProdutoValor()));
    }
    if (request.getCategoriaId() != null) {
      criteria.orOperator(Criteria.where("products.category._id").is(request.getCategoriaId()));
    }
    if (request.getCategoriaDescricao() != null) {
      criteria.orOperator(
          Criteria.where("products.category.description")
              .regex(request.getCategoriaDescricao(), "i"));
    }
    if (request.getCpf() != null) {
      criteria.orOperator(Criteria.where("taxId").is(request.getCpf()));
    }
    if (request.getValor() != null) {
      criteria.orOperator(Criteria.where("value").is(request.getValor()));
    }
    if (request.getStatusOrdem() != null) {
      criteria.orOperator(Criteria.where("orderStatus").is(request.getStatusOrdem()));
    }
    if (request.getPagamentoStatus() != null) {
      criteria.orOperator(Criteria.where("payment.paymentStatus").is(request.getPagamentoStatus()));
    }
    if (request.getPagamentoId() != null) {
      criteria.orOperator(Criteria.where("payment.paymentId").is(request.getPagamentoId()));
    }
    if (request.getDataCriacao() != null) {
      criteria.orOperator(Criteria.where("createTimestamp").is(request.getDataCriacao()));
    }
    if (request.getTempoEspera() > 0) {
      criteria.orOperator(Criteria.where("timeWaiting").is(request.getTempoEspera()));
    }

    if (!criteria.getCriteriaObject().isEmpty()) {
      query.addCriteria(criteria);
    }

    return mongoTemplate.findOne(query, OrderDocument.class);
  }
}

package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.OrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CreateOrderResponse;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.core.ports.in.CreateOrderPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

  @Autowired private OrderMapper orderMapper;

  @Autowired private CreateOrderPort createOrderPort;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Cria um novo pedido",
      description = "Recebendo a lista de produtos e valor, cria um novo pedido")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Pedido Criado com sucesso")})
  public ResponseEntity<CreateOrderResponse> createNeworder(
      @RequestBody OrderRequest orderRequest) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    // log.info("correlationId={{}} Solicitacao recebida [criarNovoPedido] ",
    // ThreadContext.get(Constants.CORRELATION_ID));
    // log.debug(orderRequest.toString());
    String vaue = createOrderPort.create(orderMapper.toOrderFromOrderRequest(orderRequest));
    return ResponseEntity.ok(new CreateOrderResponse());
  }
}

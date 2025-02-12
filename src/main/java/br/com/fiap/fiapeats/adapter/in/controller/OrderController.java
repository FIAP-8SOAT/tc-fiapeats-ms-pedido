package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CreateOrderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.GetOrderHeaderRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CreateOrderResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.OrderResponse;
import br.com.fiap.fiapeats.adapter.mapper.OrderMapper;
import br.com.fiap.fiapeats.core.ports.in.GetOrderPort;
import br.com.fiap.fiapeats.core.ports.in.ProcessOrderPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Objects;
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

  @Autowired private ProcessOrderPort processOrderPort;

  @Autowired private GetOrderPort getOrderPort;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Cria um novo pedido",
      description = "Recebendo a lista de produtos e valor, cria um novo pedido")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Pedido Criado com sucesso")})
  public ResponseEntity<CreateOrderResponse> createNewOrder(
      @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={{}} Solicitacao recebida [createNewOrder] ",
        ThreadContext.get(Constants.CORRELATION_ID));
    log.info(createOrderRequest.toString());
    return ResponseEntity.ok(
        orderMapper.toCreateOrderResponseFromOrder(
            processOrderPort.process(orderMapper.toOrderFromOrderRequest(createOrderRequest))));
  }

  @GetMapping("/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<OrderResponse> getOrderById(
      @PathVariable String orderId,
      @RequestHeader(value = "correlationId", required = false) String correlationId) {
    ThreadContext.put(
        Constants.CORRELATION_ID,
        !Objects.equals(correlationId, "") ? correlationId : UUID.randomUUID().toString());
    log.info(
        "correlationId={{}} Solicitacao recebida [getOrderById] ",
        ThreadContext.get(Constants.CORRELATION_ID));
    log.info("id=[" + orderId + "]");
    return ResponseEntity.ok(
        orderMapper.toOrderResponseFromOrder(getOrderPort.getOrderById(orderId)));
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ResponseEntity<OrderResponse>> getOrderByHeaders(
      @ModelAttribute GetOrderHeaderRequest headers,
      @RequestHeader(value = "correlationId", required = false) String correlationId) {
    ThreadContext.put(
        Constants.CORRELATION_ID,
        !Objects.equals(correlationId, "") ? correlationId : UUID.randomUUID().toString());
    log.info(
        "correlationId={{}} Solicitacao recebida [getOrderByHeaders] ",
        ThreadContext.get(Constants.CORRELATION_ID));
    log.info(headers.toString());
    getOrderPort.getOrderByParameters(headers);
    return List.of(ResponseEntity.ok(OrderResponse.builder().build()));
  }
}

package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PaymentUpdateRequest;
import br.com.fiap.fiapeats.adapter.mapper.PaymentMapper;
import br.com.fiap.fiapeats.core.ports.in.ProcessPaymentPort;
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
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

  @Autowired private PaymentMapper paymentMapper;

  @Autowired private ProcessPaymentPort processPaymentPort;

  @PatchMapping("/{idOrdem}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Atualiza status pagamento",
      description = "Atualiza o status de pagamento de um pedido")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso")})
  public void updatePaymentStatus(
      @RequestBody PaymentUpdateRequest paymentUpdateRequest, @PathVariable String idOrdem)
      throws Exception {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={{}} Solicitacao recebida [updatePaymentStatus] ",
        ThreadContext.get(Constants.CORRELATION_ID));
    log.debug(paymentUpdateRequest.toString());
    processPaymentPort.updatePayment(
        paymentMapper.toPaymentUpdateStatusFromPaymentUpdateRequest(paymentUpdateRequest, idOrdem));
  }
}

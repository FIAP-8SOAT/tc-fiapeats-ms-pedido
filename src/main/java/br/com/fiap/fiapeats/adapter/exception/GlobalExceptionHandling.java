package br.com.fiap.fiapeats.adapter.exception;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ErrorResponse;
import br.com.fiap.fiapeats.core.exceptions.ClientNotFoundException;
import br.com.fiap.fiapeats.core.exceptions.FillOrderPropertiesException;
import br.com.fiap.fiapeats.core.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandling {

  @ExceptionHandler(ClientNotFoundException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse handleClientNotFoundException(ClientNotFoundException ex) {
    return ErrorResponse.builder()
        .errorCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
        .errorName(HttpStatus.UNPROCESSABLE_ENTITY.name())
        .message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(FillOrderPropertiesException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleFillOrderException(FillOrderPropertiesException ex) {
    return ErrorResponse.builder()
        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .errorName(HttpStatus.INTERNAL_SERVER_ERROR.name())
        .message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(ProductNotFoundException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse handleProductNotFoundException(ProductNotFoundException ex) {
    return ErrorResponse.builder()
        .errorCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
        .errorName(HttpStatus.UNPROCESSABLE_ENTITY.name())
        .message(ex.getMessage())
        .build();
  }
}

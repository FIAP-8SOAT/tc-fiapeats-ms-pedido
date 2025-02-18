package br.com.fiap.fiapeats.adapter.exception;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ErrorResponse;
import br.com.fiap.fiapeats.core.exceptions.*;
import br.com.fiap.fiapeats.core.utils.Constants;
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

  @ExceptionHandler(OrderNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleOrderNotFoundException(OrderNotFoundException ex) {
    return ErrorResponse.builder()
        .errorCode(HttpStatus.NOT_FOUND.value())
        .errorName(HttpStatus.NOT_FOUND.name())
        .message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(FeignRequestException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleFeignRequestException(FeignRequestException ex) {
    return ErrorResponse.builder()
            .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .errorName(Constants.TXT_FEIGN_REQUEST_ERROR)
            .message(ex.getMessage())
            .build();
  }
}

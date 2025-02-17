package br.com.fiap.fiapeats.core.exceptions;

public class FeignRequestException extends RuntimeException {
    public FeignRequestException(String message) {
        super(message);
    }
}
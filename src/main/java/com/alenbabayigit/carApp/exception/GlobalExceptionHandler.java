package com.alenbabayigit.carApp.exception;

import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> handleBusinessException(BusinessException exception) {
    return ResponseBuilder.error(exception.getMessage());
  }
}

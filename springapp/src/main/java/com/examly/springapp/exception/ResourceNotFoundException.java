package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
        super(message);
    }
}
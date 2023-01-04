package com.example.CurrencyConverter.exceptions.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CurrencyNotFoundException extends RuntimeException{
public  CurrencyNotFoundException(String msg) {
  super(msg);
}
}

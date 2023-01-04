package com.example.CurrencyConverter.exceptions.invalidInput;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAmountInputException extends RuntimeException{
public InvalidAmountInputException(String msg) {
  super(msg);
}
}

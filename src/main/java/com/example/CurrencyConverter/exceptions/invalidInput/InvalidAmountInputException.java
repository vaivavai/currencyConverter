package com.example.CurrencyConverter.exceptions.invalidInput;

public class InvalidAmountInputException extends  RuntimeException{

  public InvalidAmountInputException(String msg) {
    super(msg);
  }

}

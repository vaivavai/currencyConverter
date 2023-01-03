package com.example.CurrencyConverter.controllers;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.services.CurrencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/currencies")
public class CurrencyController {

  private final CurrencyService currencyService;

  @Autowired
  public CurrencyController(CurrencyService currencyService) {
    this.currencyService = currencyService;
  }

  @GetMapping
  public List<Currency> getCurrencies() {
    return currencyService.getCurrencies();
  }
}

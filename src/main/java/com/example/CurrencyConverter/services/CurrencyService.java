package com.example.CurrencyConverter.services;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

  private final CurrencyRepository currencyRepository;

  @Autowired
  public CurrencyService(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  public List<Currency> getCurrencies() {
    return currencyRepository.findAll();
  }
}

package com.example.CurrencyConverter.services;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

  private final CurrencyRepository currencyRepository;

  @Autowired
  public ConverterService(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  public Double getConversionResult(String from, String to, Double quantity) {

    if (from.equalsIgnoreCase("EUR")) {

      Optional<Currency> optionalCurrency = currencyRepository.findByName(to);
      if (optionalCurrency.isPresent()) {
        return quantity * optionalCurrency.get().getRate();
      } else {

        throw new RuntimeException("can't covert to this currency");
      }
    } else {
      Optional<Currency> optionalFrom = currencyRepository.findByName(from);
      Optional<Currency> optionalTo = currencyRepository.findByName(to);
      if (optionalFrom.isPresent() && optionalTo.isPresent()) {
        return quantity / optionalFrom.get().getRate() * optionalTo.get().getRate();
      } else {
        throw new RuntimeException("can't count for these currencies");
      }
    }

  }
}

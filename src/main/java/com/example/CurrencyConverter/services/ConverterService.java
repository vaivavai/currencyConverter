package com.example.CurrencyConverter.services;

import com.example.CurrencyConverter.exceptions.invalidInput.InvalidAmountInputException;
import com.example.CurrencyConverter.exceptions.notFound.CurrencyNotFoundException;
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

    Optional<Currency> optionalCurrencyTo = currencyRepository.findByName(to.toUpperCase());

        if (optionalCurrencyTo.isEmpty()) {
          throw new CurrencyNotFoundException("Can't convert to " + to);
        }

        Optional<Currency> optionalCurrencyFrom = currencyRepository.findByName(from.toUpperCase());
        if (optionalCurrencyFrom.isEmpty()) {
          throw new CurrencyNotFoundException("Can't convert from " + from);
        }

        if (quantity > 0) {
          return quantity * optionalCurrencyTo.get().getRate()/ optionalCurrencyFrom.get().getRate();
        } else {
          throw new InvalidAmountInputException("The amount to be converted should be more than 0");

        }

  }
}

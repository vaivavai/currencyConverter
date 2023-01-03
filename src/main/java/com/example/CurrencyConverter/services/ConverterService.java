package com.example.CurrencyConverter.services;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {


  public Double getConversionResult(String from, String to, Double quantity) {
    HashMap<String, Double> rates = new HashMap<>();
    rates.put("EUR", 1.0);
    rates.put("GBP", 0.88);
    rates.put("PLN", 4.67197);

    if (from.equalsIgnoreCase("EUR")) {
      if(rates.containsKey(to.toUpperCase())) {
        return quantity * rates.get(to.toUpperCase());
      } else {
         throw new RuntimeException("can't covert to this currency");
      }
    } else {
      if(rates.containsKey(to.toUpperCase()) && rates.containsKey(from.toUpperCase())) {
        return quantity / rates.get(from.toUpperCase()) * rates.get(to.toUpperCase());
      } else {
        throw new RuntimeException("can't count for these currencies");
      }
    }

  }
}

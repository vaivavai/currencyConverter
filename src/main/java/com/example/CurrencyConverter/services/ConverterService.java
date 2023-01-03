package com.example.CurrencyConverter.services;


import static com.example.CurrencyConverter.CurrencyConverterApplication.extracted;

import com.example.CurrencyConverter.exceptions.invalidInput.InvalidAmountInputException;
import com.example.CurrencyConverter.exceptions.notFound.CurrencyNotFoundException;
import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
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

//  public Map<String, Double> getExchangeRates(String apiKey) {
//    RestTemplate restTemplate = new RestTemplate();
//    String url = "http://apilayer.net/api/live?access_key=" + apiKey;
//    ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
//    Map<String, Object> responseBody = response.getBody();
//
//    Map<String, Double> rates = new HashMap<>();
//    Map<String, Double> quotes = (Map<String, Double>) responseBody.get("quotes");
//    if (quotes != null) {
//
//      for (Map.Entry<String, Double> quote : quotes.entrySet()) {
//        String currency = quote.getKey().substring(3);
//        double rate = quote.getValue();
//        rates.put(currency, rate);
//      }
//    }
//
//    return rates;
//
//  }

//  public String convertToJson(String xml) {
//    XmlMapper xmlMapper = new XmlMapper();
//    return xmlMapper.writeValueAsString(xmlMapper.readTree(xml));
//  }

  public Double getConversionResult(String fromCurrency, String toCurrency, Double amount)
      throws IOException, URISyntaxException {
    Map<String, Double> rates = extracted();
    System.out.println(rates.toString());
    if (rates != null) {
      Double fromRate = rates.get(fromCurrency);
      Double toRate = rates.get(toCurrency);

      return amount * toRate / fromRate;
    } else {
      throw new RuntimeException("rates ar null");
    }

//  }
//
//  public Double getConversionResult(String from, String to, Double quantity) {
//
//    Optional<Currency> optionalCurrencyTo = currencyRepository.findByName(to.toUpperCase());
//
//    if (optionalCurrencyTo.isEmpty()) {
//      throw new CurrencyNotFoundException("Can't convert to " + to);
//    }
//
//    Optional<Currency> optionalCurrencyFrom = currencyRepository.findByName(from.toUpperCase());
//    if (optionalCurrencyFrom.isEmpty()) {
//      throw new CurrencyNotFoundException("Can't convert from " + from);
//    }
//
//    if (quantity > 0) {
//      return quantity * optionalCurrencyTo.get().getRate();
//    } else {
//      throw new InvalidAmountInputException("The amount to be converted should be more than 0");
//
//    }

  }
}


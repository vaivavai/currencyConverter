package com.example.CurrencyConverter.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatesApiResponse {

  private List<Currency> currencies = new ArrayList<>();

  // Convert JSON to RatesApiResponse Java Class
  // Also automatically uses addRate method below to add currencies
  // to List<Currency> variable
  public static RatesApiResponse fromJson(String json) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(json);
    JsonNode ratesNode = root.get("rates"); // we only need this from 3rd party api response
    return mapper.treeToValue(ratesNode, RatesApiResponse.class);
  }
  @JsonAnySetter
  public void addRate(String name, double rate) {
    currencies.add(new Currency(name, rate));
  }

  public List<Currency> getCurrencies() {
    return currencies;
  }
}
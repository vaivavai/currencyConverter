package com.example.CurrencyConverter.controllers;

import com.example.CurrencyConverter.services.ConverterService;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "api/v1/converter")
public class ConverterController {

  private final ConverterService converterService;

  @Autowired
  public ConverterController(ConverterService converterService) {
    this.converterService = converterService;
  }

  @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
  public Double getConversionResult(@PathVariable String from, @PathVariable String to,
      @PathVariable Double quantity) throws IOException, URISyntaxException {
    return converterService.getConversionResult(from, to, quantity);
  }

}
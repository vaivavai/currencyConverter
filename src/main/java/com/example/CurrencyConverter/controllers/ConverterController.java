package com.example.CurrencyConverter.controllers;

import com.example.CurrencyConverter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/converter")
public class ConverterController {

  private final ConverterService converterService;

  @Autowired
  public ConverterController(ConverterService converterService) {
    this.converterService = converterService;
  }

  //Get all airports
  @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
  public Double getConversionResult(@PathVariable String from, @PathVariable String to, @PathVariable Double quantity) {
    return converterService.getConversionResult();
  }

}
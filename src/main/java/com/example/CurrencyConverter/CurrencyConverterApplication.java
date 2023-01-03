package com.example.CurrencyConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CurrencyConverterApplication {

//	@JsonIgnoreProperties(ignoreUnknown = true)
//	static class FxRates {
//		@JsonProperty("FxRate")
//		List<FxRate> rates;
//	}
//
//	@JsonIgnoreProperties(ignoreUnknown = true)
//	static class FxRate {
//		@JsonProperty("Ccy")
//		String currency;
//		@JsonProperty("Amt")
//		Double rate;
//	}
//
//
//
//	public static Map<String, Double> getExchangeRates() throws JsonProcessingException {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates";
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//		String responseBody = response.getBody();
//
//		ObjectMapper mapper = new XmlMapper();
//		FxRates fxRates = mapper.readValue(responseBody, FxRates.class);
//		Map<String, Double> rates = fxRates.rates.stream()
//				.collect(Collectors.toMap(r -> r.currency, r -> r.rate));
//		return rates;
//	}
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		SpringApplication.run(CurrencyConverterApplication.class, args);

		extracted();

	}

	public static Map<String, Double> extracted() throws MalformedURLException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		URL url = new URL("http://www.floatrates.com/daily/eur.xml");
		Map<String, String> rates = restTemplate.getForObject(url.toURI(), Map.class);
		Map<String, Double> currencyRates = new HashMap<>();
		for (Map.Entry<String, String> entry : rates.entrySet()) {
			String currencyCode = entry.getKey();
			Double rate = Double.parseDouble(entry.getValue());
			currencyRates.put(currencyCode, rate);
		}
		return currencyRates;
	}

}

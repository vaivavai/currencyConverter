package com.example.CurrencyConverter.configurations;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.models.RatesApiResponse;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {

  @Autowired
  CurrencyRepository currencyRepository;

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      OkHttpClient client = new OkHttpClient().newBuilder().build();

      Request request = new Request.Builder()
          .url("https://api.apilayer.com/exchangerates_data/latest?base=eur")
          .addHeader("apikey", "U3ad6SbNX9z3kZx0dKhtQRSl2cbHqQwq")
          .build();
      Response response = client.newCall(request).execute();
      String jsonResponseString = response.body().string();

      RatesApiResponse ratesApiResponse = RatesApiResponse.fromJson(jsonResponseString);
      for (Currency el : ratesApiResponse.getCurrencies()) {
        System.out.println(el.getName());
        System.out.println(el.getRate());
      }

      currencyRepository.saveAll(ratesApiResponse.getCurrencies());

    };
  }

}

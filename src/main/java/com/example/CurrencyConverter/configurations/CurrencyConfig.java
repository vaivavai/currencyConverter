package com.example.CurrencyConverter.configurations;

import com.example.CurrencyConverter.models.RatesApiResponse;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class CurrencyConfig {

  @Autowired
  CurrencyRepository currencyRepository;

  @Value("${apilayer.currency.key}")
  private String apilayerCurrencyKey;

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      currencyRepository.deleteAll();
      OkHttpClient client = new OkHttpClient().newBuilder().build();

      Request request = new Request.Builder()
          .url("https://api.apilayer.com/exchangerates_data/latest?base=eur")
          .addHeader("apikey", apilayerCurrencyKey)
          .build();
      Response response = client.newCall(request).execute();
      String jsonResponseString = response.body().string();

      RatesApiResponse ratesApiResponse = RatesApiResponse.fromJson(jsonResponseString);
      currencyRepository.saveAll(ratesApiResponse.getCurrencies());
    };
  }

  @Scheduled(fixedRate = 30000, initialDelay = 30000) // 10 minutes in milliseconds
  public void scheduleTaskWithFixedRate() throws Exception {
    commandLineRunner().run();
  }

}

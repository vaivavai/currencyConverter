package com.example.CurrencyConverter;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.models.RatesApiResponse;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CurrencyConverterApplication.class, args);
		updateWithLiveRates();
	}

	private static void updateWithLiveRates() throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder()
				.url("https://api.apilayer.com/exchangerates_data/latest?base=eur")
				.addHeader("apikey", "{your-key}")
				.build();
		Response response = client.newCall(request).execute();
		String jsonResponseString = response.body().string();


		RatesApiResponse ratesApiResponse = RatesApiResponse.fromJson(jsonResponseString);
		for (Currency el : ratesApiResponse.getCurrencies()) {
			System.out.println(el.getName());
			System.out.println(el.getRate());
		}
	}

}

package com.example.CurrencyConverter.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.CurrencyConverter.models.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CurrencyRepositoryTest {

  @Autowired
  private CurrencyRepository underTest;

  @AfterEach
  void tearDown() {
    underTest.deleteAll();
  }

  @Test
  void should_Find_Currency_By_Name() {
    String currencyName = "GBP";
    Currency currency = new Currency(currencyName, 0.88);
    underTest.save(currency);

    Currency expected = underTest.findByName(currencyName).get();
    assertThat(expected).isEqualTo(currency);

  }
}
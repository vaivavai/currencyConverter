package com.example.CurrencyConverter.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

import com.example.CurrencyConverter.models.Currency;
import com.example.CurrencyConverter.repositories.CurrencyRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConverterServiceTest {

  @Mock
  private CurrencyRepository currencyRepository;

  private ConverterService underTest;

  @BeforeEach
  void setUp() {
    underTest = new ConverterService(currencyRepository);
  }

  @Test
  void should_Return_Correct_Rate_When_Input_Valid() {

    Double amount = 10.0;
    String currencyGBP = "GBP";
    Currency currencyFrom = new Currency(currencyGBP, 0.88);

    String currencyPLN = "PLN";
    Currency currencyTo = new Currency(currencyPLN, 4.66);

    given(currencyRepository.findByName(currencyGBP)).willReturn(Optional.of(currencyFrom));
    given(currencyRepository.findByName(currencyPLN)).willReturn(Optional.of(currencyTo));

    Double expected = underTest.getConversionResult(currencyGBP, currencyPLN, amount);
    assertThat(String.format("%.2f", expected)).isEqualTo(String.format("%.2f", 52.9545455));
  }

  @Test
  void should_Throw_If_CurrencyFrom_Does_Not_Exist() { //TODO why can't make this test the same like next???
    Double amount = 10.0;
    String currencyGPP = "GPP";
//    Currency currencyFrom = new Currency(currencyGPP, 0.88);

    String currencyPLN = "PLN";
    Currency currencyTo = new Currency(currencyPLN, 4.66);
    given(currencyRepository.findByName(currencyGPP)).willReturn(Optional.empty());
    given(currencyRepository.findByName(currencyPLN)).willReturn(Optional.of(currencyTo));

    assertThatThrownBy(() -> underTest.getConversionResult(currencyGPP, "PLN", amount)).hasMessage(
        "Can't convert from " + currencyGPP);

  }

  @Test
  void should_Throw_If_CurrencyTo_Does_Not_Exist() {
    Double amount = 10.0;

    String currencyPLNN = "PLNN";

    given(currencyRepository.findByName(currencyPLNN)).willReturn(Optional.empty());

    assertThatThrownBy(() -> underTest.getConversionResult("GBP", currencyPLNN, amount)).hasMessage(
        "Can't convert to " + currencyPLNN);

  }

  @Test
  void should_Throw_When_Amount_Input_NotValid() {

    Double amount = 0.0;
    String currencyGBP = "GBP";
    Currency currencyFrom = new Currency(currencyGBP, 0.88);

    String currencyPLN = "PLN";
    Currency currencyTo = new Currency(currencyPLN, 4.66);

    given(currencyRepository.findByName(currencyGBP)).willReturn(Optional.of(currencyFrom));
    given(currencyRepository.findByName(currencyPLN)).willReturn(Optional.of(currencyTo));

    assertThatThrownBy(
        () -> underTest.getConversionResult(currencyGBP, currencyPLN, amount)).hasMessage(
        "The amount to be converted should be more than 0");
  }
}
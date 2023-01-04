package com.example.CurrencyConverter.services;

import static org.mockito.Mockito.verify;

import com.example.CurrencyConverter.repositories.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

  @Mock
  private CurrencyRepository currencyRepository;

  private CurrencyService underTest;

  @BeforeEach
  void setUp() {
    underTest = new CurrencyService(currencyRepository);
  }

  @Test
  void should_Get_All_Currencies() {
    underTest.getCurrencies();
    verify(currencyRepository).findAll();
  }
}
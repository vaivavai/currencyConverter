package com.example.CurrencyConverter.repositories;

import com.example.CurrencyConverter.models.Currency;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

  Optional<Currency> findByName(String name);
}

# Spring Boot Currency Converter

## Description

This is a Spring Boot currency conversion application used as REST API.
* It calls https://api.apilayer.com/exchangerates_data/latest?base=eur
* Gets real-time exchange rates for 170 world currencies.
* It is called every 10 minutes to keep the latest rates

## Getting Started

* Obtain API key via https://api.apilayer.com/exchangerates_data (free)
* Or contact me and I can provide you one!
* **IMPORTANT** - Insert your key in application.properties file


### Dependencies

* PostgreSQL
* Maven 3.0+
* Java 17

### Configuring database locally
* Create a postgres database named **_postgres_**. Default port is **_5432_** on localhost
* Open src/main/resources/application.properties file and change the spring datasource username and password as per your PostgreSQL installation.

### Installing
* To prepare maven dependencies
```
mvn clean install
```

### Executing program

* To run the application
```
mvn spring-boot:run
```

## Authors
Vaiva Vaitkeviciute

 [My LinkedIn](https://www.linkedin.com/in/vaiva-v-628461237/)

## Explore Rest APIs

The app defines following CRUD APIs.

### Exchange rates

| Method | Url                         | Decription                                                         | Example Response       |
|--------|-----------------------------|---------------------------------------------------------------------------------------------|------------------------|
| GET    | api/v1/currencies           | Get exchange rates list with EUR as base currency                              | [JSON](#getcurrencies) |

### Currency Conversion

| Method         | Url                                    | Description                                             |
|----------------|----------------------------------------|--------------------------------------------------------------------------------------------------|
| GET    | api/v1/converter/from/{from}/to/{to}/quantity/{quantity}           | Get calculated money exchange value from one currency to another |                          ||



## Sample JSON Response Body's


##### <a id="getcurrencies">Get currencies and exchange rates -> api/v1/currencies</a>
```json
  {
    "id": "d9875f0d-e65f-464b-b177-5ca86c06f884",
    "name": "AED",
    "rate": 3.89326
  },
  {
    "id": "5048ec71-e821-4f53-a260-8eb79e36b97a",
    "name": "AFN",
    "rate": 92.741931
  },
  {
    "id": "47a9891b-8b9b-4ef9-8411-0bed64a8eb58",
    "name": "ALL",
    "rate": 113.572654
  },
  {
    "id": "fbc66b5a-507e-465a-ac11-1b7c9c7424b5",
    "name": "AMD",
    "rate": 418.135386
  },
  {
    "id": "5a44e6c4-d734-4883-b70d-24455bed440f",
    "name": "ANG",
    "rate": 1.910821
  },
  {
    "id": "f13b6a92-8a45-406e-8098-2670c5540c40",
    "name": "AOA",
    "rate": 533.875777
  },
  {
    "id": "999aa658-22d9-45aa-8444-43d571d9a063",
    "name": "ARS",
    "rate": 189.283204
  },
  {
    "id": "fc6e907c-0850-4dd5-ac05-85dc2e844856",
    "name": "AUD",
    "rate": 1.551559
  },
  {
    "id": "09a3af00-5e5d-4128-8203-2511aea78103",
    "name": "AWG",
    "rate": 1.907891
  },
  {
    "id": "aab0d3df-d547-4b5e-a9ee-e89b945c0ab7",
    "name": "AZN",
    "rate": 1.799925
  },
  {
    "id": "5a2c1da4-aa2c-4c47-bc17-1c8e4b2a9c46",
    "name": "BAM",
    "rate": 1.955442
  }
```
(This is a shortened response for READ ME, real response would include all 170 currencies.)


## Version History

* 1.1 WIP
    * Simple Angular UI will be added
    * Ability to specify base currency on GET /currencies
* 1.0 (Current)
    * Initial Release
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Currency } from '../Currency';
import { Rate } from '../Rate';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class CurrenciesService {

  // http client return an observable
  constructor(private http: HttpClient) {}

  getConverted(currency: Currency): Observable<number> {
    const url = `http://localhost:8080/api/v1/converter/from/${currency.fromCurrency}/to/${currency.toCurrency}/quantity/${currency.amount}`;
    return this.http.get<number>(url);
  }

  getRates(): Observable<Rate[]> {
    const url = `http://localhost:8080/api/v1/currencies`;
    return this.http.get<Rate[]>(url)
      }


}

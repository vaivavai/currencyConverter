import { Component } from '@angular/core';
import { Rate } from '../../Rate';

import { CurrenciesService } from '../../services/currencies.service';


@Component({
  selector: 'app-current-rates',
  templateUrl: './current-rates.component.html',
  styleUrls: ['./current-rates.component.css']
})
export class CurrentRatesComponent {
rates: Rate[] = [];
  constructor(private currenciesService: CurrenciesService) {}

  ngOnInit(): void {
    this.currenciesService.getRates().subscribe((rates) => (this.rates = rates));
  }
}

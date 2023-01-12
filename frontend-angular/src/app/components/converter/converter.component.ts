import { Component } from '@angular/core';
import { Currency } from '../../Currency';
import { CurrenciesService } from '../../services/currencies.service';

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css'],
})
export class ConverterComponent {

  inputAmount: string = '';
  inputFrom: string = '';
  inputTo: string = '';

  result = {
    from: '',
    to: '',
    amount: '',
    convertedAmount: ''
  };

  constructor(private currenciesService: CurrenciesService) {}

  ngOnInit(): void {}

  onSubmit() {
    if (!this.inputAmount || !this.inputFrom || !this.inputTo) {
      alert('Please fill all the fields!');
      return;
    }

    const newCurrency: Currency = {
      amount: this.inputAmount,
      fromCurrency: this.inputFrom,
      toCurrency: this.inputTo,
    };

    this.currenciesService.getConverted(newCurrency).subscribe(data => {
      this.result = {
        from: this.inputFrom,
        to: this.inputTo,
        amount: this.inputAmount,
        convertedAmount: data.toFixed(2),
      };
    });
  }
}

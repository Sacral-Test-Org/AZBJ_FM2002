import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NameMatchService {
  private selectedOption: string | null = null;

  constructor() { }

  getDropdownOptions(): Observable<string[]> {
    const options = ['Option 1', 'Option 2'];
    return of(options);
  }

  storeSelectedOption(option: string): void {
    this.selectedOption = option;
  }

  getSelectedOption(): string | null {
    return this.selectedOption;
  }
}

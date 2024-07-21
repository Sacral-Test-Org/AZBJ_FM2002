import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CounterOfferValidationService {

  constructor() { }

  validate(counterOffer: any): boolean {
    // Implement the validation logic here
    if (!counterOffer) {
      return false;
    }

    // Example validation logic
    if (counterOffer.amount <= 0) {
      return false;
    }

    if (!counterOffer.terms || counterOffer.terms.length === 0) {
      return false;
    }

    // Add more validation rules as needed

    return true;
  }
}

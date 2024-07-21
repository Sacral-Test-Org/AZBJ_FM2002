import { Component, OnInit } from '@angular/core';
import { ValidationErrorComponent } from './validation-error/validation-error.component';

@Component({
  selector: 'app-financial-uw-eligi',
  templateUrl: './financial-uw-eligi.component.html',
  styleUrls: ['./financial-uw-eligi.component.css']
})
export class FinancialUwEligiComponent implements OnInit {

  constructor(private validationErrorComponent: ValidationErrorComponent) { }

  ngOnInit(): void {
    this.formatFields();
  }

  formatFields(): void {
    // Apply formatting and color coding to the fields
  }

  navigateFields(event: KeyboardEvent): void {
    // Handle keyboard navigation between fields
  }

  validateIncomeCovers(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validatePhoneNumber(phoneNumber: string): void {
    if (isNaN(Number(phoneNumber))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    }
  }

  validateAnnualPremiumPH(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validateFinancialEligibility(inputValue: string): void {
    if (isNaN(Number(inputValue))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validateRatedUpField(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    if (isNaN(Number(input))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    }
  }

  validateIncomeCoverage(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validateDeclinedLives(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validateTotalPremiumLiability(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    if (isNaN(Number(input))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validatePpcEligibility(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    }
  }

  validatePPC_ELIG_PH(value: string): void {
    if (isNaN(Number(value))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    }
  }

  validateAnnualPremium(): void {
    const input = (document.getElementById('annualPremium') as HTMLInputElement).value;
    if (isNaN(Number(input))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  validateRatedUpPercentage(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    if (isNaN(Number(input))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    }
  }

  validateDeclinedLifePH(inputValue: string): void {
    if (isNaN(Number(inputValue))) {
      this.validationErrorComponent.showError('Please Enter valid Numeric Value');
    } else {
      this.navigateToNextField();
    }
  }

  navigateToNextField(): void {
    // Logic to move the focus to the next input field
  }
}

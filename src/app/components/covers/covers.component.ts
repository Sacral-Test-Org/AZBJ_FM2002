import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CoversService } from 'src/app/services/covers.service';

@Component({
  selector: 'app-covers',
  templateUrl: './covers.component.html',
  styleUrls: ['./covers.component.css']
})
export class CoversComponent implements OnInit {
  coversForm: FormGroup;
  cashBonusVisible: boolean = false;

  constructor(private fb: FormBuilder, private coversService: CoversService) {
    this.coversForm = this.fb.group({
      percentageIncrease: [''],
      cashBonus: ['']
    });
  }

  ngOnInit(): void {
    this.cashBonusVisible = false;
  }

  activateCoversBlock(): void {
    // Logic to activate and display the Covers block
    // This could involve setting some state variables or calling methods to update the UI
  }

  handlePercentageIncreaseInput(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    const validatedInput = this.validateInput(input);
    this.coversForm.get('percentageIncrease')?.setValue(validatedInput);
  }

  validateInput(value: string): string {
    let validatedValue = value.replace(/[^0-9]/g, ''); // Ensure numeric
    if (validatedValue.length > 30) {
      validatedValue = validatedValue.substring(0, 30); // Restrict length
    }
    return validatedValue.toUpperCase(); // Convert to uppercase
  }

  onCashBonusInput(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    this.coversForm.get('cashBonus')?.setValue(input.toUpperCase());
  }

  checkVisibilityCondition(): boolean {
    // Logic to determine if the 'Cash Bonus' field should be visible
    // This could involve checking some state variables or calling methods to get the current state
    return this.cashBonusVisible;
  }
}
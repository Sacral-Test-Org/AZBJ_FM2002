import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CoversHealthService } from 'src/app/services/covers-health.service';
import { CoversHealthDTO } from 'src/app/models/covers-health.dto';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-covers-health',
  templateUrl: './covers-health.component.html',
  styleUrls: ['./covers-health.component.css']
})
export class CoversHealthComponent implements OnInit {
  coversHealthForm: FormGroup;
  globalPremiumTerm: number;
  globalBenefitTerm: number;
  globalSumInsured: number;

  constructor(private fb: FormBuilder, private coversHealthService: CoversHealthService) {
    this.coversHealthForm = this.fb.group({
      coverCode: ['', [Validators.required, Validators.maxLength(10)]],
      coverDescription: ['', Validators.required],
      sumInsured: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      benefitTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      premiumTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      entryAge: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      annualAmount: ['', Validators.pattern('^[0-9]*$')],
      frequencyAmount: ['', Validators.pattern('^[0-9]*$')],
      standardPremium: ['', Validators.pattern('^[0-9]*$')],
      discountPercentage: ['', Validators.pattern('^[0-9]*$')],
      discountAmount: ['', Validators.pattern('^[0-9]*$')],
      roundingOffset: ['', Validators.pattern('^[0-9]*$')],
      deletion: [false]
    });
  }

  ngOnInit(): void {
    this.coversHealthService.getCoverDetails(1).subscribe((data: CoversHealthDTO[]) => {
      // Initialize form with data
    });
  }

  saveCoverDetails(coversHealthDTO: CoversHealthDTO): void {
    this.coversHealthService.saveCoverDetails(coversHealthDTO).subscribe((response: CoversHealthDTO) => {
      // Handle response
    });
  }

  onPremiumTermFieldNavigate(): void {
    const benefitTerm = this.coversHealthForm.get('benefitTerm')?.value;
    const premiumTermControl = this.coversHealthForm.get('premiumTerm');
    if (this.isFirstRecord()) {
      this.globalPremiumTerm = premiumTermControl?.value;
    }
    premiumTermControl?.setValue(benefitTerm);
  }

  validateItem(): void {
    if (this.isFirstRecord()) {
      const benefitTerm = this.coversHealthForm.get('benefitTerm')?.value;
      this.coversHealthService.setGlobalBenefitTerm(benefitTerm);
    }
  }

  handleEntryAgeInput(entryAge: number): void {
    this.coversHealthService.validateEntryAge(entryAge).subscribe(response => {
      // Handle validation response
    });
  }

  updateCalculatedTerms(entryAge: number, packageMaturityDate: Date): void {
    this.coversHealthService.calculateTerms(entryAge, packageMaturityDate).subscribe(response => {
      // Update UI with calculated terms
    });
  }

  handleHealthCoverCodeInput(event: Event): void {
    const input = (event.target as HTMLInputElement).value.toUpperCase().slice(0, 10);
    this.coversHealthForm.get('coverCode')?.setValue(input);
  }

  validateSumInsured(): Observable<any> {
    return this.coversHealthService.validateSumInsured();
  }

  navigateToNextItem(): Observable<any> {
    return this.coversHealthService.navigateToNextItem();
  }

  private isFirstRecord(): boolean {
    // Logic to determine if the current record is the first record
    return true;
  }
}

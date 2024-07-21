import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CounterOfferService } from 'src/app/services/counter-offer.service';
import { ValidationErrorComponent } from 'src/app/components/counter-offer/validation-error/validation-error.component';

@Component({
  selector: 'app-counter-offer',
  templateUrl: './counter-offer.component.html',
  styleUrls: ['./counter-offer.component.css']
})
export class CounterOfferComponent implements OnInit {
  counterOfferForm: FormGroup;
  selectedReasons: string[] = [];
  isGenerateLetterEnabled: boolean = false;
  isSubmitEnabled: boolean = false;

  constructor(
    private fb: FormBuilder,
    private counterOfferService: CounterOfferService,
    private validationErrorComponent: ValidationErrorComponent
  ) {}

  ngOnInit(): void {
    this.counterOfferForm = this.fb.group({
      packageName: ['', Validators.required],
      benefitTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      premiumTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      sumAssured: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      premium: ['', [Validators.required, Validators.pattern('^[0-9]*$')]]
    });
  }

  onClose(): void {
    // Logic to close the form
  }

  validateCounterOffer(): void {
    this.counterOfferService.validateCounterOffer().subscribe(response => {
      if (response.isValid) {
        this.isGenerateLetterEnabled = true;
      } else {
        this.validationErrorComponent.showError(response.errorMessage);
      }
    });
  }

  generateLetter(): void {
    this.counterOfferService.generateLetter().subscribe(response => {
      if (response.isGenerated) {
        this.isSubmitEnabled = true;
      } else {
        this.validationErrorComponent.showError(response.errorMessage);
      }
    });
  }

  generateBI(): void {
    this.counterOfferService.generateBI().subscribe(response => {
      if (!response.isGenerated) {
        this.validationErrorComponent.showError(response.errorMessage);
      }
    });
  }

  submitCounterOffer(): void {
    this.counterOfferService.submitCounterOffer().subscribe(response => {
      if (response.isSubmitted) {
        // Logic to handle successful submission
      } else {
        this.validationErrorComponent.showError(response.errorMessage);
      }
    });
  }

  handleCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.counterOfferService.checkProductAndGroupStatus('productId', 'groupId').subscribe(status => {
        if (status.productLinkedToUnit || status.groupProductStatus !== 'N') {
          this.validationErrorComponent.showError('Cannot modify counter offer for ULIP/GROUP cases.');
          checkbox.checked = false;
        } else if (this.counterOfferForm.get('counterOfferType').value === 'CO_IP') {
          this.validationErrorComponent.showError('Please select a different counter offer type.');
          checkbox.checked = false;
        }
      });
    }
  }

  selectReason(reason: string): void {
    if (this.selectedReasons.length >= 3) {
      this.validationErrorComponent.showError('Cannot select more than 3 reasons');
    } else {
      this.selectedReasons.push(reason);
    }
  }

  handleCounterOfferSelection(selectedOfferType: string): void {
    this.counterOfferService.validateCounterOffer(selectedOfferType).subscribe(response => {
      if (!response.isValid) {
        this.validationErrorComponent.showError(response.errorMessage);
        this.counterOfferForm.get('counterOfferType').reset();
      }
    });
  }
}
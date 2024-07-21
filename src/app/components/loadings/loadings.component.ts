import { Component } from '@angular/core';
import { LoadingsService } from 'src/app/services/loadings.service';
import { ValidationErrorComponent } from 'src/app/components/loadings/validation-error/validation-error.component';
import { PolicyMemberLoadingDetailsService } from 'src/app/services/policy-member-loading-details.service';

@Component({
  selector: 'app-loadings',
  templateUrl: './loadings.component.html',
  styleUrls: ['./loadings.component.css']
})
export class LoadingsComponent {
  coverCode: string = '';
  fromDate: Date;
  inceptionDate: Date;
  extraAmount: number;
  toDate: Date;
  benefitTerm: number;
  productId: string;
  loadingType: string;
  productDefinition: string;
  loadingPercentage: number;
  occupationLoadingPercentage: number;
  mlp: number;

  constructor(
    private loadingsService: LoadingsService,
    private validationErrorComponent: ValidationErrorComponent,
    private policyMemberLoadingDetailsService: PolicyMemberLoadingDetailsService
  ) {}

  handleKeyDown(event: KeyboardEvent): void {
    if (this.coverCode === '' && event.key === 'ArrowDown') {
      return;
    } else if (this.coverCode !== '' && event.key === 'ArrowDown') {
      this.navigateToNextRecord();
    } else if (this.coverCode === '' && event.key === 'ArrowUp') {
      this.deleteCurrentRecord();
    } else if (this.coverCode !== '' && event.key === 'ArrowUp') {
      this.navigateToPreviousRecord();
    }
  }

  validateFromDate(fromDate: Date, inceptionDate: Date, extraAmount: number): void {
    if (fromDate < inceptionDate) {
      if (extraAmount === 0) {
        this.fromDate = inceptionDate;
      } else {
        this.displayErrorMessage('From Date cannot be earlier than the inception date.');
      }
    }
  }

  displayErrorMessage(message: string): void {
    this.validationErrorComponent.showError(message);
  }

  validateExtraAmount(value: number): boolean {
    if (value < 0) {
      this.displayErrorMessage('Amount cannot be negative');
      return false;
    }
    return true;
  }

  validateSRLPercentage(): void {
    if (this.coverCode.startsWith('R') && this.coverCode !== 'R029A01' && this.srlPercentage > 0) {
      this.validationErrorComponent.showError('Special loading is not applicable for any of the riders.');
      this.srlPercentage = 0;
    } else if (this.productDefinition === 'CAPITAL_SHIELD' && this.srlPercentage > 0) {
      this.validationErrorComponent.showError('The product is not allowed on extra premium.');
      this.srlPercentage = 0;
    } else if (this.productDefinition === 'SARAL_JEEVAN_BIMA' && this.srlPercentage > 4) {
      this.validationErrorComponent.showError('Special loading is not allowed greater than 4.');
      this.srlPercentage = 4;
    }
  }

  validateToDate(fromDate: Date, toDate: Date, benefitTerm: number, inceptionDate: Date, extraAmount: number): void {
    if (toDate < fromDate) {
      this.validationErrorComponent.showError('To Date cannot be less than From Date.');
      return;
    }
    const calculatedEndDate = new Date(inceptionDate);
    calculatedEndDate.setMonth(calculatedEndDate.getMonth() + benefitTerm);
    if (toDate > calculatedEndDate) {
      if (extraAmount === 0) {
        this.toDate = calculatedEndDate;
      } else {
        this.validationErrorComponent.showError('To Date cannot be greater than the term end date.');
      }
    }
  }

  validateLoadingType(productId: string, loadingType: string): void {
    if ((productId === '277' || productId === '271') && loadingType !== 'PER_THOUSAND_SA') {
      this.validationErrorComponent.showError('Invalid loading type for the product.');
    }
  }

  navigateToNextItem(currentLoadingType: string, coverCode: string): void {
    if (coverCode.startsWith('L')) {
      this.loadingsService.storeLoadingType(currentLoadingType);
    } else if (coverCode.startsWith('T') || coverCode === 'R024A01' || coverCode === 'R018A01') {
      this.loadingsService.applyLoadingType(currentLoadingType, coverCode);
    }
    this.loadingsService.navigateToNextRecord();
  }

  validateLoadingPercentage(productDefinition: string, coverCode: string, loadingPercentage: number): void {
    if (['SWAYAM_SHAKTI_SURAKSHA', 'SARVE_SHAKTI_SURAKSHA', 'GROUP_SEVA_PLAN', 'GROUP_LEAVE_ENCASHMENT', 'GROUP_CREDIT_PROTECT', 'GROUP_CREDIT_PROTECTION_PLUS', 'NIYAMIT_SANCHAY_SURAKSHA', 'NIYAMIT_SANCHAY_SURKSHA_SINGLE'].includes(productDefinition) && !coverCode.startsWith('L') && loadingPercentage > 0) {
      this.validationErrorComponent.showError('Please load Main cover');
    }
    this.updateFormStatus('Y');
  }

  updateFormStatus(status: string): void {
    this.formStatus = status;
  }

  navigateToNextItem(coverCode: string, loadingPercentage: number): void {
    if (coverCode.startsWith('L')) {
      this.storedLoadingPercentage = loadingPercentage;
    } else if (coverCode.startsWith('T') || coverCode === 'R024A01' || coverCode === 'R018A01') {
      this.loadingPercentage = this.storedLoadingPercentage;
    }
  }

  validateOccupationLoading(productDefinition: string, occupationLoadingPercentage: number, coverCode: string): void {
    this.loadingsService.validateLoading(productDefinition, occupationLoadingPercentage, coverCode).subscribe((result) => {
      if (!result.isValid) {
        this.displayErrorMessage(result.errorMessage);
      }
    });
  }

  closeLoadingWindow(): void {
    this.populateRiders();
    this.router.navigate(['/covers']);
    this.coversComponent.focusOnItem();
    this.hideLoadingWindow();
  }

  validateMLP(coverCode: string, productDefinition: string, mlp: number): void {
    this.loadingsService.validateMLP(coverCode, productDefinition, mlp).subscribe((result) => {
      if (!result.isValid) {
        this.displayErrorMessage(result.errorMessage);
      }
    });
  }

  displayValidationMessages(validationResponse: any): void {
    if (validationResponse.errorMessage) {
      this.validationErrorComponent.showError(validationResponse.errorMessage);
    } else if (validationResponse.warningMessage) {
      this.validationErrorComponent.showWarning(validationResponse.warningMessage);
    }
  }

  navigateToCoversSection(): void {
    this.validateLoadings();
    this.router.navigate(['/covers']);
  }

  fetchFirstRecord(): any {
    return this.loadingsService.fetchFirstRecord();
  }

  checkLoadingDetails(): void {
    this.policyMemberLoadingDetailsService.getLoadingDetailsRecords().subscribe((records) => {
      records.forEach((record) => {
        if (!this.isMemberDetailPresent(record)) {
          this.updateLoadingDetails(record);
        }
      });
    });
  }

  updateLoadingDetails(policyMember: any): void {
    if (policyMember.relation !== 'Son' && policyMember.relation !== 'Daughter' && policyMember.relation !== 'Child') {
      this.policyMemberLoadingDetailsService.addLoadingDetailsRecord(policyMember);
    }
  }

  private navigateToNextRecord(): void {
    // Logic to navigate to the next record
  }

  private deleteCurrentRecord(): void {
    // Logic to delete the current record
  }

  private navigateToPreviousRecord(): void {
    // Logic to navigate to the previous record
  }

  private populateRiders(): void {
    // Logic to populate riders
  }

  private hideLoadingWindow(): void {
    // Logic to hide the loading window
  }

  private isMemberDetailPresent(record: any): boolean {
    // Logic to check if member detail is present
    return false;
  }
}

import { Component } from '@angular/core';
import { BeneficiariesService } from 'src/app/services/beneficiaries.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-beneficiaries',
  templateUrl: './beneficiaries.component.html',
  styleUrls: ['./beneficiaries.component.css']
})
export class BeneficiariesComponent {
  sharePercentage: number;
  premiumFrequency: string | null;
  beneficiaryName: string;
  beneficiaryDOB: Date;
  policyInceptionDate: Date;
  productId: number;
  insuredPersonAge: number;
  nominationNotOpted: boolean;

  constructor(private beneficiariesService: BeneficiariesService, private logger: NGXLogger) {}

  validateSharePercentage(sharePercentage: number): void {
    if (sharePercentage > 100) {
      this.logger.error('Share Percentage cannot be more than 100%');
    }
  }

  onNominationNotOptedChange(event: Event): void {
    this.nominationNotOpted = (event.target as HTMLInputElement).checked;
    if (this.nominationNotOpted) {
      this.beneficiaryName = 'Nomination not opted';
      this.clearFields();
    } else {
      // Logic to enable fields
    }
  }

  clearFields(): void {
    this.beneficiaryName = '';
    this.beneficiaryDOB = null;
    // Clear other fields
  }

  handleGenderSelection(event: Event): void {
    const gender = (event.target as HTMLSelectElement).value;
    this.beneficiariesService.saveGenderSelection(gender);
  }

  deleteNominee(nomineeId: number): void {
    this.beneficiariesService.deleteNominee(nomineeId).subscribe();
  }

  validateSurnameField(): void {
    if (this.premiumFrequency) {
      this.disableButtons();
    }
    this.convertToUpperCase();
  }

  disableButtons(): void {
    // Logic to disable buttons
  }

  convertToUpperCase(): void {
    this.beneficiaryName = this.beneficiaryName.toUpperCase();
  }

  calculateEntryAgeAndNavigate(beneficiaryDOB: Date, policyInceptionDate: Date, productId: number): void {
    const age = this.calculateAge(beneficiaryDOB, policyInceptionDate);
    if (age < 18) {
      // Navigate to Applicant Name field
    } else if ([14, 31, 32, 33, 34, 49, 50].includes(productId)) {
      // Navigate to Spouse Details field
    } else {
      // Navigate to Sum Assured field
    }
  }

  validateItem(premiumFrequency: string): void {
    if (premiumFrequency) {
      this.disableButtons();
    }
  }

  adjustBeneficiaryRelationshipField(): void {
    if (this.insuredPersonAge < 18) {
      // Set beneficiary relationship to match policy holder's relationship
      // Disable beneficiary relationship field
    } else {
      // Enable beneficiary relationship field
    }
  }

  validateRelationshipInput(relationship: string): void {
    if (this.premiumFrequency) {
      this.disableButtons();
    }
    // Navigate to beneficiary's date of birth field
  }

  validateDOB(dateOfBirth: Date): boolean {
    const age = this.calculateAge(dateOfBirth, new Date());
    if (age < 18) {
      this.logger.error('The appointee cannot be a minor again.');
      return false;
    }
    return true;
  }

  disableFormActions(premiumFrequency: string): void {
    if (premiumFrequency) {
      this.disableButtons();
    }
  }

  validateBeneficiaryName(): void {
    this.beneficiaryName = '100';
    if (this.premiumFrequency) {
      this.disableButtons();
    }
  }

  checkInsuredPersonAge(): void {
    if (this.insuredPersonAge < 18) {
      this.logger.error('Nomination is not allowed for minors.');
      this.clearFields();
      // Disable input fields
    } else {
      // Enable input fields
    }
  }

  addMultipleNomineeButtonHandler(): void {
    this.beneficiariesService.fetchNomineeDetails('applicationNo', 'proposalNo').subscribe(nominees => {
      if (nominees.length > 0) {
        const firstNominee = nominees[0];
        const age = this.calculateAge(firstNominee.dob, new Date());
        if (age < 18) {
          this.logger.warn('Minor Nominee(s) found.. Please enter the Appointee Details..');
        }
      } else {
        // Allow adding new nominee details
      }
    });
  }

  onAppointeeNameChange(appointeeName: string): void {
    if (this.beneficiariesService.validateAppointeeName(appointeeName)) {
      // Navigate to appointee's relationship field
    }
  }

  validateBeneficiaryDOB(beneficiaryDOB: Date): void {
    const age = this.calculateAge(beneficiaryDOB, new Date());
    if (age >= 18) {
      this.clearAppointeeFields();
      this.logger.warn('An appointee cannot be entered for a major.');
    } else {
      // Enable appointee fields
    }
  }

  addTrusteeBeneficiary(): void {
    if (this.isMWPFlagSet()) {
      this.navigateToMWPAct();
      this.beneficiariesService.getBeneficiaryTrusteeRecords().subscribe(records => {
        // Populate MWP_ACT section with records
      });
    }
  }

  navigateToBeneficiaryName(): void {
    // Logic to navigate to beneficiary's name field
  }

  saveBeneficialOwnerRecord(): void {
    const beneficialOwner = this.getBeneficialOwnerDetails();
    const validationResponse = this.beneficiariesService.validateBeneficialOwnerRecord(beneficialOwner);
    if (!validationResponse.isValid) {
      this.logger.error('Please enter all details.');
    }
  }

  private calculateAge(dob: Date, referenceDate: Date): number {
    const diff = referenceDate.getTime() - dob.getTime();
    return Math.floor(diff / (1000 * 60 * 60 * 24 * 365.25));
  }

  private isMWPFlagSet(): boolean {
    // Logic to check if MWP flag is set
    return true;
  }

  private navigateToMWPAct(): void {
    // Logic to navigate to MWP_ACT section
  }

  private clearAppointeeFields(): void {
    // Logic to clear appointee fields
  }

  private getBeneficialOwnerDetails(): any {
    // Logic to get beneficial owner details
    return {};
  }
}

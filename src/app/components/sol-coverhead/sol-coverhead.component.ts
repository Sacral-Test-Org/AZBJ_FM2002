import { Component, OnInit } from '@angular/core';
import { SolCoverheadService } from 'src/app/services/sol-coverhead.service';
import { SolCoversService } from 'src/app/services/sol-covers.service';
import { Router } from '@angular/router';
import { FurtherReqService } from 'src/app/services/further-req.service';

@Component({
  selector: 'app-sol-coverhead',
  templateUrl: './sol-coverhead.component.html',
  styleUrls: ['./sol-coverhead.component.css']
})
export class SolCoverheadComponent implements OnInit {
  sumAssured: number;
  solutionName: string;
  productDefinition: string;
  pensionFlag: number;
  bookingFrequency: string;
  dateOfBirth: Date;
  vestingAge: number;
  contractId: string;

  constructor(
    private solCoverheadService: SolCoverheadService,
    private solCoversService: SolCoversService,
    private router: Router,
    private furtherReqService: FurtherReqService
  ) {}

  ngOnInit(): void {
    this.solCoverheadService.getSumAssured().subscribe(sumAssured => {
      this.sumAssured = sumAssured;
      this.checkAndUpdateSumInsured(sumAssured);
    });
  }

  checkAndUpdateSumInsured(sumAssured: number): void {
    this.solCoverheadService.getSolutionName().subscribe(solutionName => {
      if (sumAssured != null && solutionName !== '1') {
        this.solCoversService.updateSumInsured(sumAssured).subscribe();
      }
    });
  }

  calculateAndValidateTerms(): void {
    this.solCoverheadService.calculateTerms().subscribe(terms => {
      // Update component state with calculated terms
    });
  }

  handleMoneyBackOption(): void {
    const options = ['Option 1', 'Option 2', 'Option 3'];
    // Logic to handle Money Back Option
  }

  handleDiscountSelection(discountOption: string): void {
    this.solCoverheadService.getDiscountOptions().subscribe(options => {
      // Handle discount selection logic
    });
  }

  calculateAndUpdateTerms(productDefinition: string, pensionFlag: number, bookingFrequency: string, dateOfBirth: Date, vestingAge: number): void {
    this.solCoverheadService.calculateTerms(productDefinition, pensionFlag, bookingFrequency, dateOfBirth, vestingAge).subscribe(terms => {
      // Update component state with calculated terms
    });
  }

  navigateToNextItem(): void {
    // Logic to navigate to the next item in the form
  }

  validateAndPopulateInvestmentAmount(): void {
    this.solCoverheadService.validateSolutionName(this.solutionName).subscribe(isValid => {
      if (!isValid && this.sumAssured) {
        // Prompt user to select a solution name
      }
      if (this.solutionName === '1') {
        this.solCoverheadService.calculateBeneficiaryAge(this.dateOfBirth).subscribe(age => {
          if (age >= 12) {
            // Display error message
          } else {
            // Populate solution product details and navigate to SOL_COVERS section
          }
        });
      }
    });
  }

  onOkButtonClick(): void {
    this.solCoverheadService.processRecords().subscribe(() => {
      this.router.navigate(['/sol-covers']);
    });
  }

  determineDiscountType(): void {
    this.solCoverheadService.getDiscountType().subscribe(discountType => {
      // Update component state with discount type
    });
  }

  onCheckboxChange(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    if (isChecked) {
      this.furtherReqService.checkMaritalStatus(this.solutionName).subscribe(isValid => {
        if (isValid) {
          this.furtherReqService.createOrUpdateRecord('M470', 'MWP ADDENDUM', new Date(), 'USER CALLED').subscribe();
        } else {
          // Display message and uncheck the checkbox
        }
      });
    } else {
      this.furtherReqService.deleteRecord('M470').subscribe(() => {
        this.solCoverheadService.deleteBeneficiaryTrusteeRep(this.contractId).subscribe(() => {
          // Commit transaction
        });
      });
    }
  }
}

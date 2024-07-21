import { Component, OnInit } from '@angular/core';
import { ReinsurerSelectionService } from 'src/app/services/reinsurer-selection.service';
import { ReinsuranceCoverDetailsService } from 'src/app/services/reinsurance-cover-details.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reinsurance-cover-details',
  templateUrl: './reinsurance-cover-details.component.html',
  styleUrls: ['./reinsurance-cover-details.component.css']
})
export class ReinsuranceCoverDetailsComponent implements OnInit {
  coverDetails: any[] = [];
  calculatedReinsuranceAmount: number = 0;

  constructor(
    private reinsurerSelectionService: ReinsurerSelectionService,
    private reinsuranceCoverDetailsService: ReinsuranceCoverDetailsService
  ) {}

  ngOnInit(): void {
    this.getReinsuranceCoverDetails();
  }

  getReinsuranceCoverDetails(): void {
    this.reinsurerSelectionService.getReinsuranceCoverDetails().subscribe(
      (data) => {
        this.coverDetails = data;
      },
      (error) => {
        console.error('Error fetching reinsurance cover details', error);
      }
    );
  }

  deleteCoverDetail(id: string): void {
    this.reinsurerSelectionService.deleteReinsuranceCoverDetail(id).subscribe(
      () => {
        this.coverDetails = this.coverDetails.filter(detail => detail.id !== id);
      },
      (error) => {
        console.error('Error deleting reinsurance cover detail', error);
      }
    );
  }

  validateOccPercField(): void {
    const occPercField = this.coverDetails.find(detail => detail.fieldName === 'OCC Perc');
    if (occPercField && occPercField.value > 0 && occPercField.productDefinition === 'CAPITAL_SHIELD') {
      console.error('Product not allowed on extra premium');
    }
  }

  validateSpecialRiskPercentage(): void {
    const spField = this.coverDetails.find(detail => detail.fieldName === 'Special Risk Percentage');
    if (spField && spField.value > 0 && spField.productDefinition === 'CAPITAL_SHIELD') {
      console.error('Product not allowed on extra premium');
    }
  }

  updateCalculatedValues(): void {
    this.reinsuranceCoverDetailsService.getCalculatedValues().subscribe(
      (calculatedValues) => {
        // Update the component properties with the calculated values
        this.coverDetails.forEach(detail => {
          if (calculatedValues[detail.fieldName]) {
            detail.value = calculatedValues[detail.fieldName];
          }
        });
      },
      (error) => {
        console.error('Error fetching calculated values', error);
      }
    );
  }

  validateMedicalLoadingPercentage(coverCode: string, medicalLoadingPercentage: number, productDefinition: string, nonResidentInsurancePercentage: number): Observable<any> {
    return this.reinsuranceCoverDetailsService.validateMedicalLoadingPercentage(coverCode, medicalLoadingPercentage, productDefinition, nonResidentInsurancePercentage).subscribe(
      (response) => {
        if (!response.isValid) {
          console.error(response.errorMessage);
        }
      },
      (error) => {
        console.error('Error validating medical loading percentage', error);
      }
    );
  }

  calculateReinsuranceAmount(reinsurancePercentage: number, coverAmount: number): void {
    this.reinsuranceCoverDetailsService.calculateReinsuranceAmount(reinsurancePercentage, coverAmount).subscribe(
      (calculatedAmount) => {
        this.calculatedReinsuranceAmount = calculatedAmount;
      },
      (error) => {
        console.error('Error calculating reinsurance amount', error);
      }
    );
  }

  onCoverCodeDoubleClick(): void {
    this.reinsuranceCoverDetailsService.getCoverCodes().subscribe(
      (coverCodes) => {
        // Logic to display the list of values (LOV) for the user to select from
        console.log('Cover Codes:', coverCodes);
      },
      (error) => {
        console.error('Error fetching cover codes', error);
      }
    );
  }
}

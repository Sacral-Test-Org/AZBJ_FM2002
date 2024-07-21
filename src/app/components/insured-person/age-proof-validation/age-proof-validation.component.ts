import { Component } from '@angular/core';
import { InsuredPersonService } from 'src/app/services/insured-person.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-age-proof-validation',
  templateUrl: './age-proof-validation.component.html',
  styleUrls: ['./age-proof-validation.component.css']
})
export class AgeProofValidationComponent {
  constructor(private insuredPersonService: InsuredPersonService, private logger: NGXLogger) {}

  validateAgeProofID(ageProofType: string, ageProofID: string): void {
    if ((ageProofType === 'AC' || ageProofType === 'ACS') && ageProofID.length === 12) {
      this.logger.info('Validating Aadhaar data');
      this.insuredPersonService.validateAgeProofID(ageProofType, ageProofID).subscribe(
        (response) => {
          this.logger.info('Aadhaar data validated successfully', response);
          // Update the age proof ID with the validated Aadhaar data
        },
        (error) => {
          this.logger.error('Error validating Aadhaar data', error);
        }
      );
    } else if (ageProofType === 'Pan Card' && ageProofID) {
      this.logger.info('Validating PAN card data');
      this.insuredPersonService.validateAgeProofID(ageProofType, ageProofID).subscribe(
        (response) => {
          this.logger.info('PAN card data validated successfully', response);
          // Assign the age proof ID to the agent's PAN card and set verification status
        },
        (error) => {
          this.logger.error('Error validating PAN card data', error);
        }
      );
    } else {
      this.logger.warn('Invalid age proof type or ID');
    }
  }
}

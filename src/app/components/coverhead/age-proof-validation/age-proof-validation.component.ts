import { Component, Input } from '@angular/core';
import { CoverheadComponent } from '../coverhead.component';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-age-proof-validation',
  templateUrl: './age-proof-validation.component.html',
  styleUrls: ['./age-proof-validation.component.css']
})
export class AgeProofValidationComponent {
  @Input() ageProofDetails: any;

  constructor(private coverheadComponent: CoverheadComponent, private logger: NGXLogger) {}

  validateAgeProof() {
    try {
      const result = this.coverheadComponent.determineAgeProofType(this.ageProofDetails);
      if (result === 'N') {
        this.logger.info('Non-standard Age Proof');
        alert('Non-standard Age Proof');
      } else if (result === 'Y') {
        this.logger.info('Standard Age Proof');
        alert('Standard Age Proof');
      } else {
        throw new Error('Unexpected result');
      }
    } catch (error) {
      this.logger.error('Error determining age proof type', error);
      alert('Error determining age proof type');
    }
  }
}

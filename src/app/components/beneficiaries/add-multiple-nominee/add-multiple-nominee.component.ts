import { Component } from '@angular/core';
import { NomineeDetails } from 'src/app/models/nominee-details.model';
import { BeneficiariesService } from 'src/app/services/beneficiaries.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-add-multiple-nominee',
  templateUrl: './add-multiple-nominee.component.html',
  styleUrls: ['./add-multiple-nominee.component.css']
})
export class AddMultipleNomineeComponent {
  constructor(private beneficiariesService: BeneficiariesService, private logger: NGXLogger) {}

  addNominee(nomineeDetails: NomineeDetails): void {
    this.beneficiariesService.saveNomineeDetails(nomineeDetails).subscribe({
      next: () => {
        this.logger.info('Nominee details saved successfully');
      },
      error: (err) => {
        this.logger.error('Error saving nominee details', err);
      }
    });
  }
}

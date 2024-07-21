import { Component, OnInit } from '@angular/core';
import { SpouseDetailsService } from 'src/app/services/spouse-details.service';
import { HorizontalToolbarComponent } from 'src/app/components/horizontal-toolbar/horizontal-toolbar.component';
import { ProofTypeDTO } from 'src/app/models/proof-type-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-spouse-details',
  templateUrl: './spouse-details.component.html',
  styleUrls: ['./spouse-details.component.css']
})
export class SpouseDetailsComponent implements OnInit {
  proofTypes: ProofTypeDTO[] = [];
  selectedProofType: ProofTypeDTO | null = null;
  CV_FREQ_PREM: any = null; // This should be set based on your application logic

  constructor(private spouseDetailsService: SpouseDetailsService, private toolbar: HorizontalToolbarComponent) {}

  ngOnInit(): void {
    this.getProofTypes();
  }

  validateSpouseSurname(): void {
    if (this.CV_FREQ_PREM !== null) {
      this.toolbar.disableToolbarButtons();
    }
  }

  validateSpouseName(): void {
    // Assuming there's a related field to set a specific value
    const relatedFieldValue = 100;
    // Set the related field value here

    if (this.CV_FREQ_PREM !== null) {
      this.toolbar.disableToolbarButtons();
    }
  }

  validateDOB(dob: Date): void {
    const currentDate = new Date();
    if (dob > currentDate) {
      console.error('Date of birth cannot be greater than the current date.');
      return;
    }

    this.spouseDetailsService.validateSpouseDOB({ dob }).subscribe(response => {
      if (!response.isValid) {
        console.error(response.message);
        return;
      }

      const entryAge = this.calculateEntryAge(dob);
      if (entryAge >= 18 && this.appointeeName) {
        this.clearAppointeeDetails();
        console.warn('An appointee cannot be entered for a major.');
      }

      if (this.CV_FREQ_PREM !== null) {
        this.toolbar.disableToolbarButtons();
      }
    });
  }

  getProofTypes(): void {
    this.spouseDetailsService.getProofTypes().subscribe(proofTypes => {
      this.proofTypes = proofTypes;
    });
  }

  onProofTypeSelect(event: Event): void {
    const selectedProofType = (event.target as HTMLSelectElement).value;
    this.saveProofType(selectedProofType);
  }

  saveProofType(proofType: string): void {
    this.spouseDetailsService.saveProofType(proofType).subscribe(() => {
      console.log('Proof type saved successfully');
    });
  }

  calculateSpouseNetProfit(): void {
    const premiumPayer = 3; // Assuming this value is set based on your application logic
    if (premiumPayer === 3) {
      this.spouseDetailsService.calculateNetProfit().subscribe(netProfit => {
        console.log('Calculated Net Profit:', netProfit);
      });
    }
  }

  private calculateEntryAge(dob: Date): number {
    const policyInceptionDate = new Date(); // Replace with actual policy inception date
    const ageDifMs = policyInceptionDate.getTime() - dob.getTime();
    const ageDate = new Date(ageDifMs);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  }

  private clearAppointeeDetails(): void {
    this.appointeeName = null;
    this.appointeeRelation = null;
    this.appointeeDOB = null;
  }

  appointeeName: string | null = null;
  appointeeRelation: string | null = null;
  appointeeDOB: Date | null = null;
}

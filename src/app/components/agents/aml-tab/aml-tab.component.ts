import { Component } from '@angular/core';
import { AmlService } from 'src/app/services/aml.service';
import { ProofDetailsDTO, AmlValidationRequest, AmlValidationResponse } from 'src/app/models/aml.model';

@Component({
  selector: 'app-aml-tab',
  templateUrl: './aml-tab.component.html',
  styleUrls: ['./aml-tab.component.css']
})
export class AmlTabComponent {
  aadharInput: string;
  amlDetails: any = {};
  proofDetails: ProofDetailsDTO;

  constructor(private amlService: AmlService) {}

  handleAadharInput(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    this.aadharInput = input;
  }

  handleCheckboxChange(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    if (isChecked) {
      const request: AmlValidationRequest = this.createAmlValidationRequest();
      this.amlService.validateAmlDetails(request).subscribe((response: AmlValidationResponse) => {
        this.populateAmlDetails(response);
      });
    } else {
      this.resetAmlDetails();
    }
  }

  onProofTypeDoubleClick(): void {
    this.amlService.fetchProofDetails(this.aadharInput).subscribe((details: ProofDetailsDTO) => {
      this.displayProofDetails(details);
    });
  }

  displayProofDetails(proofDetails: ProofDetailsDTO): void {
    this.proofDetails = proofDetails;
  }

  private createAmlValidationRequest(): AmlValidationRequest {
    // Create and return the AML validation request object
    return {
      aadharInput: this.aadharInput,
      // Add other necessary fields
    };
  }

  private populateAmlDetails(response: AmlValidationResponse): void {
    this.amlDetails = response;
  }

  private resetAmlDetails(): void {
    this.amlDetails = {};
  }
}

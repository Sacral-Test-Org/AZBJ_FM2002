import { Component, OnInit } from '@angular/core';
import { ClientEnvironmentValidationService } from 'src/app/services/client-environment-validation.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-client-environment-validation',
  templateUrl: './client-environment-validation.component.html',
  styleUrls: ['./client-environment-validation.component.css']
})
export class ClientEnvironmentValidationComponent implements OnInit {

  constructor(private clientEnvValidationService: ClientEnvironmentValidationService) { }

  ngOnInit(): void {
    this.triggerValidationProcess();
  }

  triggerValidationProcess(): void {
    // Logic to trigger the validation process
    this.clientEnvValidationService.validatePolicy().subscribe(
      response => this.handleValidationResponse(response),
      error => this.displayErrorMessage('Validation process failed.')
    );
  }

  onRateButtonClick(): void {
    this.validatePolicy();
  }

  validatePolicy(): void {
    this.clientEnvValidationService.validatePolicy().subscribe(
      response => this.handleValidationResponse(response),
      error => this.displayErrorMessage('Policy validation failed.')
    );
  }

  validatePartnerReferences(): void {
    this.clientEnvValidationService.validatePartnerReferences().subscribe(
      response => {
        if (!response.partnerReference) {
          this.displayErrorMessage('Cannot Skip Policy As Partner Is Not Created. Kindly Create Partner And Proceed.');
        } else {
          // Proceed to next step
        }
      },
      error => this.displayErrorMessage('Partner validation failed.')
    );
  }

  displayErrorMessage(message: string): void {
    // Logic to display error message on the UI
    alert(message);
  }

  onValidatePolicyClick(): void {
    this.clientEnvValidationService.validatePolicy().subscribe(
      response => this.handleValidationResponse(response),
      error => this.displayErrorMessage('Policy validation failed.')
    );
  }

  handleValidationResponse(response: any): void {
    if (response.success && response.controlValue === 'T' && response.resultField) {
      // Logic to disable a specific item
    } else if (!response.success) {
      this.displayErrorMessage('Validation failed.');
    }
  }

  onValidateButtonClick(): void {
    this.clientEnvValidationService.validatePolicy().subscribe(
      response => this.handleValidationResponse(response),
      error => this.displayErrorMessage('Validation failed.')
    );
  }

  onReasonForManualClick(): void {
    const applicationNumber = 'someApplicationNumber'; // Replace with actual application number
    this.clientEnvValidationService.getManualCasePushMessages(applicationNumber).subscribe(
      response => {
        if (response.messages && response.messages.length > 0) {
          // Logic to display messages in the UI
        } else {
          this.displayErrorMessage('No Details available for this case.');
        }
      },
      error => this.displayErrorMessage('Failed to retrieve manual case push messages.')
    );
  }
}

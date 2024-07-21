import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  @Input() errorMessages: string[] = [];

  displayErrorMessages(errorMessages: string[]): void {
    this.errorMessages = errorMessages;
  }

  displayError(errorMessage: string): void {
    this.errorMessages = [errorMessage];
  }

  displayErrorMessage(errorMessage: string): void {
    this.errorMessages = [errorMessage];
  }

  displayErrors(errorMessages: string[]): void {
    this.errorMessages = errorMessages;
  }

  showError(message: string): void {
    this.errorMessages = [message];
  }
}
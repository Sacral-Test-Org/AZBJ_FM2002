import { Component } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  errorMessage: string = '';

  displayErrorMessage(message: string): void {
    this.errorMessage = message;
  }

  displayValidationError(errorMessage: string): void {
    this.displayErrorMessage(errorMessage);
  }

  displayError(errorMessage: string): void {
    this.displayErrorMessage(errorMessage);
  }
}

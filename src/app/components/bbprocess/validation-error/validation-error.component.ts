import { Component } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  errorMessage: string = '';

  displayValidationError(errorMessage: string): void {
    this.errorMessage = errorMessage;
    this.handleErrorMessage();
  }

  handleErrorMessage(): void {
    // Logic to display the error message
    if (this.errorMessage) {
      alert(this.errorMessage); // For simplicity, using alert to display the error message
    }
  }
}

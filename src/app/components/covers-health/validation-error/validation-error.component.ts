import { Component } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  errorMessage: string = '';

  displayError(message: string): void {
    this.errorMessage = message;
    // Logic to display the error message
    alert(this.errorMessage); // For simplicity, using alert to display the error
  }
}
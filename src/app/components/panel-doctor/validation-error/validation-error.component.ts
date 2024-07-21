import { Component } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  errorMessage: string = '';

  showError(message: string): void {
    this.errorMessage = message;
  }

  displayErrorMessage(message: string): void {
    this.showError(message);
  }
}

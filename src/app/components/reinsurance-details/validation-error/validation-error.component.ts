import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  @Input() errorMessages: string[] = [];

  displayValidationErrors(errors: string[]): void {
    this.errorMessages = errors;
  }

  displayValidationError(errorMessage: string): void {
    this.errorMessages = [errorMessage];
  }
}

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  @Input() errors: string[] = [];

  displayErrors(errors: string[]): void {
    this.errors = errors;
  }

  displayError(errorMessage: string): void {
    this.errors = [errorMessage];
  }

  showError(message: string): void {
    this.errors = [message];
  }
}
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  @Input() errorMessage: string;

  displayErrorMessage(errorMessage: string): void {
    this.errorMessage = errorMessage;
  }
}

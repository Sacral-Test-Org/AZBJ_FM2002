import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  @Input() errors: string[] = [];
  @Input() message: string = '';

  displayErrors(errors: string[]): void {
    this.errors = errors;
  }

  displayErrorMessage(message: string): void {
    this.message = message;
  }
}

import { Component } from '@angular/core';
import { NgxLoggerLevel, LoggerService } from 'ngx-logger';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  constructor(private logger: LoggerService) {}

  displayError(errorMessage: string): void {
    // Logic to display the error message in the UI
    alert(errorMessage);
    this.logger.log(NgxLoggerLevel.ERROR, errorMessage);
  }

  displayValidationError(message: string): void {
    // Logic to display the validation error message passed as input
    this.displayError(message);
  }
}

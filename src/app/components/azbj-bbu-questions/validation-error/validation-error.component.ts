import { Component } from '@angular/core';
import { NgxLoggerLevel, LoggerService } from 'ngx-logger';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent {
  errorMessage: string = '';

  constructor(private logger: LoggerService) {}

  showError(errorMessage: string): void {
    this.setErrorMessage(errorMessage);
    this.logger.log(NgxLoggerLevel.ERROR, errorMessage);
  }

  setErrorMessage(errorMessage: string): void {
    this.errorMessage = errorMessage;
  }
}

import { Component, Input } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-exit-validation',
  templateUrl: './exit-validation.component.html',
  styleUrls: ['./exit-validation.component.css']
})
export class ExitValidationComponent {
  @Input() result: string;

  constructor(private logger: NGXLogger) {}

  displayValidationResult(result: string): void {
    this.result = result;
    this.logger.info('Validation Result: ' + result);
  }
}

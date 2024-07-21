import { Component } from '@angular/core';
import { AzbjBbuQuestionsComponent } from '../azbj-bbu-questions.component';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-close-button',
  templateUrl: './close-button.component.html',
  styleUrls: ['./close-button.component.css']
})
export class CloseButtonComponent {
  constructor(private azbjBbuQuestionsComponent: AzbjBbuQuestionsComponent, private logger: NGXLogger) {}

  closeButtonClickHandler(): void {
    this.logger.debug('Close button clicked');
    try {
      this.azbjBbuQuestionsComponent.handleCloseButtonClick();
    } catch (error) {
      this.logger.error('Error occurred while handling close button click', error);
    }
  }
}
import { Component } from '@angular/core';
import { ThirdPartyChequeService } from 'src/app/services/third-party-cheque.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-third-party-cheque',
  templateUrl: './third-party-cheque.component.html',
  styleUrls: ['./third-party-cheque.component.css']
})
export class ThirdPartyChequeComponent {
  paymentMode: string = '';
  questions: string = '';
  confidencePercentage: number = 0;
  confidenceOptions: number[] = Array.from({ length: 20 }, (_, i) => (i + 1) * 5);

  constructor(private thirdPartyChequeService: ThirdPartyChequeService, private logger: NGXLogger) {}

  saveThirdPartyChequeDetails(): void {
    if (this.questions.length > 1000) {
      this.logger.error('Questions length exceeds 1000 characters');
      return;
    }
    this.thirdPartyChequeService.saveThirdPartyChequeDetails(this.paymentMode, this.questions, this.confidencePercentage)
      .subscribe(
        response => {
          this.logger.info('Third-party cheque details saved successfully', response);
        },
        error => {
          this.logger.error('Error saving third-party cheque details', error);
        }
      );
  }

  handleConfidenceSelection(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.confidencePercentage = Number(target.value);
  }
}

import { Component } from '@angular/core';
import { AzbjCoDetailsService } from 'src/app/services/azbj-co-details.service';
import { GstCalculationRequest } from 'src/main/java/com/azbj/fm2002/dto/GstCalculationRequest';
import { GstCalculationResponse } from 'src/main/java/com/azbj/fm2002/dto/GstCalculationResponse';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-azbj-co-details',
  templateUrl: './azbj-co-details.component.html',
  styleUrls: ['./azbj-co-details.component.css']
})
export class AzbjCoDetailsComponent {
  constructor(private azbjCoDetailsService: AzbjCoDetailsService, private logger: NGXLogger) {}

  onGenerateBiReport(): void {
    this.azbjCoDetailsService.generateBiReport().subscribe(
      (response) => {
        if (response.success) {
          // Update BI details in AZBJ_CO_DETAILS section
          this.updateBiDetails(response.data);
        } else {
          // Display warning message and reset visual attributes
          this.displayWarning(response.message);
        }
      },
      (error) => {
        // Handle internal server error
        this.displayWarning('Internal server error occurred.');
        this.logger.error('BI report generation failed', error);
      }
    );
  }

  calculateGst(premium: number, sumAssured: number): void {
    if (premium <= 0) {
      this.displayValidationError('Premium cannot be less than or equal to zero.');
      return;
    }

    const request: GstCalculationRequest = {
      productId: this.getProductId(),
      coverCode: this.getCoverCode(),
      premium: premium,
      effectiveDate: this.getEffectiveDate(),
      policyYear: 1,
      mailAddPinCode: this.getMailAddPinCode(),
      servAddPinCode: this.getServAddPinCode(),
      sumAssured: sumAssured,
      eventCode: 'PREMIUM'
    };

    this.azbjCoDetailsService.calculateGst(request).subscribe(
      (response: GstCalculationResponse) => {
        this.displayGstAmount(response.totalGstAmount);
      },
      (error) => {
        this.displayValidationError('Failed to calculate GST.');
        this.logger.error('GST calculation failed', error);
      }
    );
  }

  private updateBiDetails(data: any): void {
    // Logic to update BI details in AZBJ_CO_DETAILS section
  }

  private displayWarning(message: string): void {
    // Logic to display warning message
  }

  private displayValidationError(message: string): void {
    // Logic to display validation error message
  }

  private displayGstAmount(amount: number): void {
    // Logic to display GST amount
  }

  private getProductId(): number {
    // Logic to get product ID
    return 0;
  }

  private getCoverCode(): string {
    // Logic to get cover code
    return '';
  }

  private getEffectiveDate(): Date {
    // Logic to get effective date
    return new Date();
  }

  private getMailAddPinCode(): string {
    // Logic to get mail address pin code
    return '';
  }

  private getServAddPinCode(): string {
    // Logic to get service address pin code
    return '';
  }
}
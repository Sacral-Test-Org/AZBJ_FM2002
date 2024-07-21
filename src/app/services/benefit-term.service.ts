import { Injectable } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class BenefitTermService {
  private globalBenefitTerm: number | null = null;
  private readonly excludedProductIds: string[] = ['PRODUCT1', 'PRODUCT2', 'PRODUCT3'];
  private readonly productDefinitions: string[] = ['ISECURE_LOAN', 'ISECLOANV2'];

  constructor(private logger: NGXLogger) {}

  validateBenefitTerm(productId: string, benefitTerm: number, isFirstRecord: boolean): boolean {
    if (!this.excludedProductIds.includes(productId)) {
      if (isFirstRecord) {
        this.globalBenefitTerm = benefitTerm;
        this.logger.info('Benefit term stored in global variable:', this.globalBenefitTerm);
      }
      this.disableToolbarButtons();
      this.setFormStatus('Y');
      return true;
    }
    return false;
  }

  adjustPremiumTerm(productDefinition: string, benefitTerm: number): number {
    if (this.productDefinitions.includes(productDefinition)) {
      const premiumTerm = Math.trunc((2 / 3) * benefitTerm);
      this.logger.info('Premium term adjusted to:', premiumTerm);
      return premiumTerm;
    }
    return benefitTerm;
  }

  private disableToolbarButtons(): void {
    // Logic to disable commit and exit form buttons on the toolbar
    this.logger.info('Toolbar buttons disabled');
  }

  private setFormStatus(status: string): void {
    // Logic to set the form status
    this.logger.info('Form status set to:', status);
  }
}

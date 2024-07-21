import { Component } from '@angular/core';
import { SolSsoFundService } from 'src/app/services/sol-sso-fund.service';
import { NGXLogger } from 'ngx-logger';
import { Observable } from 'rxjs';
import { Fund } from 'src/app/models/fund.model';

@Component({
  selector: 'app-sol-sso-fund',
  templateUrl: './sol-sso-fund.component.html',
  styleUrls: ['./sol-sso-fund.component.css']
})
export class SolSsoFundComponent {
  constructor(private solSsoFundService: SolSsoFundService, private logger: NGXLogger) {}

  validateApportionment(productId: number, fundId: string, apportionmentPercentage: number): void {
    this.solSsoFundService.validateApportionment(productId, fundId, apportionmentPercentage).subscribe(
      (response) => {
        if (response.valid) {
          this.updateFormStatus('Y');
        } else {
          this.displayErrorMessage('Apportionment for Cash Plus Pension Fund cannot be more than 20');
        }
      },
      (error) => {
        this.logger.error('Error validating apportionment', error);
      }
    );
  }

  handleDoubleClickFundName(): void {
    if (this.isGlobalLoadingStatusF()) {
      this.updateFormStatus('Y');
      this.navigateToSection('covers');
      this.selectFirstRecord();
      this.navigateToSection('SSO_FUND');

      const productId = this.getProductId();
      const dateRange = this.getDateRange();
      const coverCode = this.getCoverCode();

      this.solSsoFundService.fetchFunds(productId, dateRange, coverCode).subscribe(
        (funds: Fund[]) => {
          const filteredFunds = funds.filter(fund => fund.fundId !== 'FVFD000025');
          this.populateLOV(filteredFunds);
          this.displayLOV();
        },
        (error) => {
          this.logger.error('Error fetching funds', error);
        }
      );
    }
  }

  private updateFormStatus(status: string): void {
    // Logic to update form status
  }

  private displayErrorMessage(message: string): void {
    // Logic to display error message
  }

  private isGlobalLoadingStatusF(): boolean {
    // Logic to check global loading status
    return true; // Placeholder return value
  }

  private navigateToSection(section: string): void {
    // Logic to navigate to a specific section
  }

  private selectFirstRecord(): void {
    // Logic to select the first record in a section
  }

  private getProductId(): string {
    // Logic to get the product ID
    return '31'; // Placeholder return value
  }

  private getDateRange(): string {
    // Logic to get the date range
    return '2023-01-01 to 2023-12-31'; // Placeholder return value
  }

  private getCoverCode(): string {
    // Logic to get the cover code
    return 'COVER123'; // Placeholder return value
  }

  private populateLOV(funds: Fund[]): void {
    // Logic to populate the list of values (LOV)
  }

  private displayLOV(): void {
    // Logic to display the list of values (LOV)
  }
}

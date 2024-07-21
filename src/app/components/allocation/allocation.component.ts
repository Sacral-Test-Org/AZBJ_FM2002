import { Component } from '@angular/core';
import { AllocationService } from 'src/app/services/allocation.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-allocation',
  templateUrl: './allocation.component.html',
  styleUrls: ['./allocation.component.css']
})
export class AllocationComponent {
  constructor(private allocationService: AllocationService) {}

  onPopulateAllocationClick(): void {
    this.allocationService.populateAllocation().subscribe(
      response => {
        console.log('Allocation populated successfully', response);
      },
      error => {
        console.error('Error populating allocation', error);
      }
    );
  }

  deleteFund(fundId: string): void {
    this.allocationService.deleteFund(fundId).subscribe(
      response => {
        console.log('Fund deleted successfully', response);
      },
      error => {
        if (error.status === 400 && error.error.message === 'Minimum one fund should be required under Auto Transfer!') {
          alert('Minimum one fund should be required under Auto Transfer!');
        } else {
          console.error('Error deleting fund', error);
        }
      }
    );
  }

  validateDiscountTypeSelection(discountType: string): void {
    this.allocationService.validateDiscountType(discountType).subscribe(
      response => {
        if (response.valid) {
          this.checkULAllocations();
        } else {
          alert(response.message);
          // Reset discount type selection logic here
        }
      },
      error => {
        console.error('Error validating discount type', error);
      }
    );
  }

  enableDisableFields(portfolioStrategy: string, productId: string): void {
    this.allocationService.getFundDetails(portfolioStrategy, productId).subscribe(
      response => {
        // Logic to enable/disable fields based on response
      },
      error => {
        console.error('Error getting fund details', error);
      }
    );
  }

  autoPopulateFunds(portfolioStrategy: string, productId: number): void {
    this.allocationService.populateFunds(portfolioStrategy, productId).subscribe(
      response => {
        // Logic to auto-populate funds based on response
      },
      error => {
        console.error('Error auto-populating funds', error);
      }
    );
  }

  handleFieldEnableDisable(portfolioStrategy: string, productDefinition: string, productId: number, packageCode: string): void {
    if (portfolioStrategy === 'SO' && ['NEW_UG_PLUS_SP', 'WEALTH_GAIN', 'WEALTH_GAIN_II', 'FLEXI_ADVANTAGE', 'GUARANTEED_MATURITY_INSURANCE', 'FORTUNE_GAIN', 'GOAL_BASED_SAVINGS', 'SMART_WEALTH_GOAL', 'SMART_CHILD_WEALTH_GOAL', 'JOINT_LIFE_WEALTH'].includes(productDefinition)) {
      // Enable fields
    } else {
      // Disable fields
    }

    if (productDefinition === 'MONEY_SECURE_PLAN') {
      this.setDefaultPortfolioStrategy(productDefinition);
    }

    if ([307, 316, 331].includes(productId) && ['TB', 'AT', 'CP'].includes(portfolioStrategy)) {
      this.autoPopulateFunds(portfolioStrategy, productId);
    }

    if ([307, 316, 331].includes(productId) && ['TB', 'WL', 'CP'].includes(portfolioStrategy)) {
      // Disable PB_DEL_FUND field
    } else {
      // Enable PB_DEL_FUND field
    }

    if (productId === 311 && portfolioStrategy === 'SO' && !packageCode.includes('SINGLE')) {
      this.displayErrorMessage('Switching option is allowed only for single premium');
      // Reset portfolio strategy logic here
    }
  }

  setDefaultPortfolioStrategy(productDefinition: string): void {
    if (productDefinition === 'MONEY_SECURE_PLAN') {
      // Set portfolio strategy to 'IS'
    }
  }

  displayErrorMessage(message: string): void {
    alert(message);
  }

  private checkULAllocations(): void {
    // Logic to check UL allocations
  }
}

import { Component } from '@angular/core';
import { BlockAlertService } from 'src/app/services/block-alert.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-block-alert',
  templateUrl: './block-alert.component.html',
  styleUrls: ['./block-alert.component.css']
})
export class BlockAlertComponent {
  constructor(private blockAlertService: BlockAlertService, private router: Router) {}

  handleRadioButtonChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    if (target.name === 'funds' && target.value === 'Y') {
      document.getElementsByName('mobile')[0].focus();
    } else if (target.name === 'funds' && target.value !== 'Y') {
      this.clearCurrentBlock();
      this.setControlValues();
      this.navigateToInsuredPerson();
      this.hideAlertListWindow();
    }
    this.validateProceedButton();
  }

  proceedButtonState(): void {
    const conditionsMet = this.validateConditions();
    const proceedButton = document.getElementById('proceedButton') as HTMLButtonElement;
    if (conditionsMet) {
      proceedButton.disabled = false;
      proceedButton.tabIndex = 0;
    } else {
      proceedButton.disabled = true;
      proceedButton.tabIndex = -1;
    }
  }

  handleRadReceiptChange(): void {
    const radReceipt = document.querySelector('input[name="RAD_RECEIPT"]:checked') as HTMLInputElement;
    if (radReceipt && radReceipt.value === 'Y') {
      document.getElementsByName('RAD_PREMIUM')[0].focus();
    }
  }

  handleRadReceiptNotY(): void {
    const radReceipt = document.querySelector('input[name="RAD_RECEIPT"]:checked') as HTMLInputElement;
    if (radReceipt && radReceipt.value !== 'Y') {
      this.clearCurrentBlock();
      this.setAction('W');
      this.updatePolicyStatus();
      this.navigateToInsuredPerson();
      this.hideAlertListWindow();
    }
  }

  handleRadioDispatchChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    if (target.value === 'Y') {
      this.router.navigate(['RAD_RECEIPT']);
    } else {
      this.clearCurrentBlock();
      this.setAction('W');
      this.updatePolicyStatus();
      this.navigateToInsuredPerson();
      this.hideAlertListWindow();
    }
  }

  validateProceedButton(): void {
    const conditionsMet = this.validateConditions();
    const proceedButton = document.getElementById('proceedButton') as HTMLButtonElement;
    if (conditionsMet) {
      proceedButton.disabled = false;
      proceedButton.tabIndex = 0;
    } else {
      proceedButton.disabled = true;
      proceedButton.tabIndex = -1;
    }
  }

  checkConditions(): void {
    const conditionsMet = this.validateConditions();
    const proceedButton = document.getElementById('proceedButton') as HTMLButtonElement;
    if (conditionsMet) {
      proceedButton.disabled = false;
      proceedButton.tabIndex = 0;
    } else {
      proceedButton.disabled = true;
      proceedButton.tabIndex = -1;
    }
  }

  onMobileRadioButtonChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    if (target.value === 'Y') {
      this.navigateToInsuredPerson();
    } else {
      this.clearCurrentBlock();
      this.setControlValues();
      this.navigateToInsuredPerson();
      this.hideAlertListWindow();
    }
  }

  onBackdationChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    this.blockAlertService.validateBackdation(target.checked).subscribe(response => {
      if (response.valid) {
        this.validateProceedButton();
      } else {
        alert('Warning: Inception date is earlier than the specific date. Please update the date of commencement.');
        this.router.navigate(['update-date-of-commencement']);
      }
    });
  }

  onProceedClick(): void {
    const proceedButton = document.getElementById('proceedButton') as HTMLButtonElement;
    if (!proceedButton.disabled) {
      this.router.navigate(['next-screen']);
    }
  }

  handleProceedButtonState(): void {
    const conditionsMet = this.validateConditions();
    const proceedButton = document.getElementById('proceedButton') as HTMLButtonElement;
    if (conditionsMet) {
      proceedButton.disabled = false;
      proceedButton.tabIndex = 0;
    } else {
      proceedButton.disabled = true;
      proceedButton.tabIndex = -1;
    }
  }

  navigateBasedOnExcessPremium(): void {
    const excessPremium = document.querySelector('input[name="excessPremium"]:checked') as HTMLInputElement;
    const productID = document.getElementById('productID') as HTMLInputElement;
    if (excessPremium && excessPremium.value === 'Y') {
      if (productID.value === 'Y' || productID.value === 'P') {
        document.getElementsByName('funds')[0].focus();
      } else {
        document.getElementsByName('mobile')[0].focus();
      }
    } else {
      this.clearCurrentBlock();
      this.setControlValues();
      this.navigateToInsuredPerson();
      this.hideAlertListWindow();
    }
  }

  private validateConditions(): boolean {
    const radBackdation = document.querySelector('input[name="RAD_BACKDATION"]:checked') as HTMLInputElement;
    const radioDispatch = document.querySelector('input[name="RADIO_DISPATCH"]:checked') as HTMLInputElement;
    const radReceipt = document.querySelector('input[name="RAD_RECEIPT"]:checked') as HTMLInputElement;
    const radPremium = document.querySelector('input[name="RAD_PREMIUM"]:checked') as HTMLInputElement;
    const radRider = document.querySelector('input[name="RAD_RIDDER"]:checked') as HTMLInputElement;
    const radExcessPre = document.querySelector('input[name="RAD_EXCESS_PRE"]:checked') as HTMLInputElement;
    const radMob = document.querySelector('input[name="RAD_MOB"]:checked') as HTMLInputElement;
    const vPrcdBtn = document.getElementById('V_PRCD_BTN') as HTMLInputElement;
    const cnProductId = document.getElementById('cn_product_id') as HTMLInputElement;
    const radFunds = document.querySelector('input[name="RAD_FUNDS"]:checked') as HTMLInputElement;

    const allRadiosValid = [radBackdation, radioDispatch, radReceipt, radPremium, radRider, radExcessPre, radMob].every(radio => radio && (radio.value === 'N' || radio.value === 'Y'));
    const proceedBtnValid = vPrcdBtn && (vPrcdBtn.value === 'X' || radExcessPre && (radExcessPre.value === 'N' || radExcessPre.value === 'Y'));
    const productValid = cnProductId && (cnProductId.value !== 'Y' && cnProductId.value !== 'P');
    const alternativeValid = cnProductId && (cnProductId.value === 'Y' || cnProductId.value === 'P') && radFunds && radFunds.value === 'Y';

    return allRadiosValid && (proceedBtnValid && (productValid || alternativeValid));
  }

  private clearCurrentBlock(): void {
    // Logic to clear the current block
  }

  private setControlValues(): void {
    // Logic to set specific control values
  }

  private navigateToInsuredPerson(): void {
    this.router.navigate(['insured-person']);
  }

  private hideAlertListWindow(): void {
    // Logic to hide the alert list window
  }

  private setAction(action: string): void {
    // Logic to set the action
  }

  private updatePolicyStatus(): void {
    // Logic to update the policy status
  }
}

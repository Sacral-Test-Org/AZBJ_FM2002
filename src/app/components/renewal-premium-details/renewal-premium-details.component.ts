import { Component } from '@angular/core';
import { PolicyHolderComponent } from '../policy-holder/policy-holder.component';

@Component({
  selector: 'app-renewal-premium-details',
  templateUrl: './renewal-premium-details.component.html',
  styleUrls: ['./renewal-premium-details.component.css']
})
export class RenewalPremiumDetailsComponent {
  constructor(private policyHolderComponent: PolicyHolderComponent) {}

  closeRenewalPremiumDetails(): void {
    // Hide the Renewal Premium Details window
    const renewalPremiumDetailsWindow = document.getElementById('renewalPremiumDetailsWindow');
    if (renewalPremiumDetailsWindow) {
      renewalPremiumDetailsWindow.style.display = 'none';
    }

    // Focus on the Method of Payment field in the Policy Holder section
    this.policyHolderComponent.focusMethodOfPaymentField();
  }
}

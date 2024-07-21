import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountDetailsService } from 'src/app/services/account-details.service';
import { BankDetails } from 'src/app/models/bank-details.model';
import { AccountDetails } from 'src/app/models/account-details.model';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {
  accountForm: FormGroup;
  relationshipTypes: string[] = ['Self', 'Spouse', 'Parent', 'Child'];
  pennyDropStatus: string = '';

  constructor(private fb: FormBuilder, private accountDetailsService: AccountDetailsService) { }

  ngOnInit(): void {
    this.accountForm = this.fb.group({
      accountNumber: ['', Validators.required],
      accountHolderName: ['', Validators.required],
      bankName: [{ value: '', disabled: true }, Validators.required],
      branch: [{ value: '', disabled: true }, Validators.required],
      micr: [{ value: '', disabled: true }, Validators.required],
      ifscCode: ['', Validators.required],
      typeOfAccount: ['', Validators.required],
      relationshipWithPremiumPayer: ['', Validators.required],
      bypassBankDetails: [false]
    });

    this.accountForm.get('bypassBankDetails').valueChanges.subscribe((checked: boolean) => {
      this.handleBypassCheckboxChange(checked);
    });
  }

  fetchBankDetails(ifscCode: string): void {
    this.accountDetailsService.getBankDetails(ifscCode).subscribe(
      (bankDetails: BankDetails) => this.displayBankDetails(bankDetails),
      (error) => console.error('Error fetching bank details', error)
    );
  }

  submitForm(): void {
    if (this.accountForm.valid) {
      const accountDetails: AccountDetails = this.accountForm.value;
      this.accountDetailsService.saveAccountDetails(accountDetails).subscribe(
        (response) => console.log('Account details saved successfully', response),
        (error) => console.error('Error saving account details', error)
      );
    }
  }

  handleBypassCheckboxChange(checked: boolean): void {
    const controls = ['accountNumber', 'accountHolderName', 'bankName', 'branch', 'micr', 'ifscCode', 'typeOfAccount', 'relationshipWithPremiumPayer'];
    if (checked) {
      controls.forEach(control => this.accountForm.get(control).disable());
      this.accountForm.reset();
    } else {
      controls.forEach(control => this.accountForm.get(control).enable());
    }
  }

  onAccountTypeChange(event: Event): void {
    const selectedType = (event.target as HTMLSelectElement).value;
    const ifscCode = this.getIfscCodeForAccountType(selectedType);
    if (ifscCode) {
      this.fetchBankDetails(ifscCode);
    }
  }

  displayBankDetails(bankDetails: BankDetails): void {
    this.accountForm.patchValue({
      bankName: bankDetails.bankName,
      branch: bankDetails.bankBranch,
      micr: bankDetails.bankMicr
    });
  }

  handleRelationshipTypeSelection(selectedType: string): void {
    this.accountForm.patchValue({
      relationshipWithPremiumPayer: selectedType
    });
  }

  handleIfscInput(ifscCode: string): void {
    this.fetchBankDetails(ifscCode);
  }

  private getIfscCodeForAccountType(accountType: string): string {
    // Mock implementation, replace with actual logic to get IFSC code based on account type
    const ifscMapping = {
      'Savings': 'IFSC001',
      'Current': 'IFSC002'
    };
    return ifscMapping[accountType] || '';
  }
}
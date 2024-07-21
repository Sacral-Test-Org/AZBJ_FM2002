import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BeneficiariesService } from 'src/app/services/beneficiaries.service';
import { MwpActService } from 'src/app/services/mwp-act.service';
import { BeneficiaryTrusteeDTO } from 'src/app/models/beneficiary-trustee-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-mwp-act',
  templateUrl: './mwp-act.component.html',
  styleUrls: ['./mwp-act.component.css']
})
export class MwpActComponent implements OnInit {
  mwpActForm: FormGroup;
  beneficiaries: BeneficiaryTrusteeDTO[] = [];
  trustees: any[] = [];
  relationshipTypes: string[] = ['Spouse', 'Child', 'Parent'];
  opusDate: Date = new Date(); // Assume this is fetched from a service

  constructor(
    private fb: FormBuilder,
    private beneficiariesService: BeneficiariesService,
    private mwpActService: MwpActService
  ) {
    this.mwpActForm = this.fb.group({
      beneficiaryName: ['', Validators.required],
      dob: ['', Validators.required],
      share: ['', Validators.required],
      relationship: [''],
      trusteeName: ['', Validators.required],
      trusteeAddress: [''],
      signDate: ['', Validators.required],
      witnessName: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getBeneficiaries();
    this.getTrustees();
  }

  getBeneficiaries(): void {
    this.beneficiariesService.getBeneficiaryTrusteeRecords().subscribe(records => {
      this.populateMWPActSection(records);
    });
  }

  getTrustees(): void {
    // Logic to fetch trustees
  }

  populateMWPActSection(records: BeneficiaryTrusteeDTO[]): void {
    this.beneficiaries = records;
    this.beneficiaries.forEach((record, index) => {
      if (!record.signDate) {
        record.signDate = new Date();
      }
    });
    // Set focus on the Beneficiary Name field
    document.getElementById('beneficiaryName')?.focus();
  }

  handleSave(): void {
    if (this.mwpActForm.valid) {
      const formData = this.mwpActForm.value;
      this.mwpActService.saveBeneficiaryTrusteeInfo(formData).subscribe(() => {
        alert('Saved Successfully');
        this.mwpActForm.reset();
      });
    } else {
      alert('Please fill all mandatory fields');
    }
  }

  handleNavigation(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      document.getElementById('witnessName')?.focus();
    }
  }

  onSaveButtonClick(): void {
    if (this.validateForm()) {
      const formData = this.mwpActForm.value;
      this.mwpActService.saveBeneficiaryTrusteeInfo(formData).subscribe(() => {
        alert('Saved Successfully');
        this.mwpActForm.reset();
      });
    }
  }

  validateForm(): boolean {
    if (!this.mwpActForm.get('beneficiaryName')?.value) {
      alert('Beneficiary name cannot be null');
      return false;
    }
    if (!this.mwpActForm.get('trusteeName')?.value) {
      alert('Trustee name cannot be null');
      return false;
    }
    if (!this.mwpActForm.get('witnessName')?.value) {
      alert('Witness name cannot be null');
      return false;
    }
    return true;
  }

  validateBeneficiaryName(): void {
    if (!this.mwpActForm.get('beneficiaryName')?.value) {
      alert('Beneficiary name cannot be null');
    }
  }

  validateDOB(dob: Date): void {
    if (dob >= this.opusDate) {
      alert('The Date of birth cannot be same as or greater than opus date');
    }
  }

  validateTrusteeName(): void {
    if (!this.mwpActForm.get('trusteeName')?.value) {
      alert('Trustee name cannot be null');
    }
  }

  onSubmit(): void {
    this.validateTrusteeName();
    if (this.mwpActForm.valid) {
      this.handleSave();
    }
  }

  navigateToWitnessName(): void {
    document.getElementById('trusteeAddress')?.addEventListener('keydown', (event: KeyboardEvent) => {
      if (event.key === 'Enter') {
        document.getElementById('witnessName')?.focus();
      }
    });
  }
}
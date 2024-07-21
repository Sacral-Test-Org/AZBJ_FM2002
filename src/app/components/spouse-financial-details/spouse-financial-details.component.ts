import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SpouseFinancialDetailsService } from 'src/app/services/spouse-financial-details.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-spouse-financial-details',
  templateUrl: './spouse-financial-details.component.html',
  styleUrls: ['./spouse-financial-details.component.css']
})
export class SpouseFinancialDetailsComponent implements OnInit {
  spouseFinancialDetailsForm: FormGroup;
  totalIncome: number = 0;
  netIncome: number = 0;

  constructor(
    private fb: FormBuilder,
    private spouseFinancialDetailsService: SpouseFinancialDetailsService,
    private logger: NGXLogger
  ) {
    this.spouseFinancialDetailsForm = this.fb.group({
      proofType: ['', Validators.required],
      grossIncome: [0, Validators.required],
      exemptedIncome: [0, Validators.required],
      oneTimeIncome: [0, Validators.required],
      deductions: [0, Validators.required],
      tax: [0, Validators.required]
    });
  }

  ngOnInit(): void {
    this.spouseFinancialDetailsForm.valueChanges.subscribe(values => {
      this.calculateTotalIncome(values);
      this.calculateNetIncome(values);
    });
  }

  calculateTotalIncome(values: any): void {
    this.totalIncome = values.grossIncome + values.exemptedIncome + values.oneTimeIncome;
  }

  calculateNetIncome(values: any): void {
    this.netIncome = this.totalIncome - (values.deductions + values.tax);
  }

  saveSpouseFinancialDetails(): void {
    if (this.spouseFinancialDetailsForm.valid) {
      const spouseFinancialDetailsDTO = this.spouseFinancialDetailsForm.value;
      this.spouseFinancialDetailsService.saveSpouseFinancialDetails(spouseFinancialDetailsDTO).subscribe(
        response => {
          this.logger.info('Spouse financial details saved successfully', response);
        },
        error => {
          this.logger.error('Error saving spouse financial details', error);
        }
      );
    }
  }
}

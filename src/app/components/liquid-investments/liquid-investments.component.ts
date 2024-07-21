import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LiquidInvestmentsService } from 'src/app/services/liquid-investments.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-liquid-investments',
  templateUrl: './liquid-investments.component.html',
  styleUrls: ['./liquid-investments.component.css']
})
export class LiquidInvestmentsComponent implements OnInit {
  investmentForm: FormGroup;
  totalInvestment: string = '0';

  constructor(
    private fb: FormBuilder,
    private investmentService: LiquidInvestmentsService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.investmentForm = this.fb.group({
      fixedTermDeposits: [0, Validators.required],
      mutualFunds: [0, Validators.required],
      equityShares: [0, Validators.required],
      ulPolicies: [0, Validators.required],
      bankBalances: [0, Validators.required],
      oneTimeIncomes: [0, Validators.required],
      otherInvestments: [0, Validators.required]
    });
  }

  calculateTotalInvestment(): void {
    const values = this.investmentForm.value;
    const total =
      values.fixedTermDeposits +
      values.mutualFunds +
      values.equityShares +
      values.ulPolicies +
      values.bankBalances +
      values.oneTimeIncomes +
      values.otherInvestments;

    this.totalInvestment = this.formatTotalInvestment(total);
    this.logger.info('Total Investment calculated:', this.totalInvestment);
  }

  private formatTotalInvestment(total: number): string {
    return total.toLocaleString('en-IN', {
      maximumFractionDigits: 2,
      style: 'currency',
      currency: 'INR'
    });
  }
}

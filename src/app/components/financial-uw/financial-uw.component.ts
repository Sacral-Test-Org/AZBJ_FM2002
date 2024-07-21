import { Component, OnInit } from '@angular/core';
import { FinancialUwService } from 'src/app/services/financial-uw.service';
import { FinancialUwDTO } from 'src/app/models/financial-uw-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-financial-uw',
  templateUrl: './financial-uw.component.html',
  styleUrls: ['./financial-uw.component.css']
})
export class FinancialUwComponent implements OnInit {
  financialDetails: FinancialUwDTO[] = [];
  proofTypes: string[] = ['PF', 'ITR', 'Computation'];
  selectedProofType: string = '';

  constructor(private financialUwService: FinancialUwService) {}

  ngOnInit(): void {
    this.financialUwService.getFinancialDetails().subscribe((details: FinancialUwDTO[]) => {
      this.financialDetails = details;
    });
  }

  saveFinancialDetails(financialDetails: FinancialUwDTO): void {
    this.financialUwService.saveFinancialDetails(financialDetails).subscribe(() => {
      console.log('Financial details saved successfully');
    });
  }

  calculateTotalIncome(grossIncome: number, exemptedIncome: number, oneTimeIncome: number): number {
    return grossIncome + exemptedIncome + oneTimeIncome;
  }

  calculateNetProfit(totalIncome: number, deductions: number, tax: number): number {
    return totalIncome - (deductions + tax);
  }

  onProofTypeChange(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.selectedProofType = target.value;
  }
}
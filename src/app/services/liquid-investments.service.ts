import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LiquidInvestmentsService {

  constructor() { }

  calculateTotalInvestment(investmentValues: { fixedTermDeposits: number, mutualFunds: number, equityShares: number, ulPolicies: number, bankBalances: number, oneTimeIncomes: number, otherInvestments: number }): string {
    const totalInvestment = investmentValues.fixedTermDeposits +
                            investmentValues.mutualFunds +
                            investmentValues.equityShares +
                            investmentValues.ulPolicies +
                            investmentValues.bankBalances +
                            investmentValues.oneTimeIncomes +
                            investmentValues.otherInvestments;

    return this.formatInvestment(totalInvestment);
  }

  private formatInvestment(amount: number): string {
    return amount.toLocaleString('en-IN', { maximumFractionDigits: 2 });
  }
}

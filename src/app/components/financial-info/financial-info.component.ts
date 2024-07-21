import { Component, OnInit } from '@angular/core';
import { FinancialInfoService } from '../../services/financial-info.service';
import { FinancialData } from '../../models/financial-data.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-financial-info',
  templateUrl: './financial-info.component.html',
  styleUrls: ['./financial-info.component.css']
})
export class FinancialInfoComponent implements OnInit {
  owner: string = '';
  shares: number[] = [];
  totalShares: number = 0;

  constructor(private financialInfoService: FinancialInfoService) {}

  ngOnInit(): void {
    this.financialInfoService.getFinancialData().subscribe((data: FinancialData) => {
      this.owner = data.owner;
      this.shares = data.shares;
      this.calculateTotalShares(this.shares);
    });
  }

  calculateTotalShares(shares: number[]): void {
    this.totalShares = shares.reduce((sum, share) => sum + share, 0);
  }
}

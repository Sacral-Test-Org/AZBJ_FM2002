import { Component, OnInit } from '@angular/core';
import { RiskDeclarationService } from '../../services/risk-declaration.service';
import { RiskDeclaration } from '../../models/risk-declaration.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-risk-declaration',
  templateUrl: './risk-declaration.component.html',
  styleUrls: ['./risk-declaration.component.css']
})
export class RiskDeclarationComponent implements OnInit {
  riskDeclarations: RiskDeclaration[] = [];
  currentIndex: number = 0;

  constructor(private riskDeclarationService: RiskDeclarationService) { }

  ngOnInit(): void {
    this.riskDeclarationService.getRiskDeclarations().subscribe((data: RiskDeclaration[]) => {
      this.riskDeclarations = data;
    });
  }

  navigateRecords(direction: string): void {
    if (direction === 'next' && this.currentIndex < this.riskDeclarations.length - 1) {
      this.currentIndex++;
    } else if (direction === 'previous' && this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

  handleDropdownChange(event: Event): void {
    const selectedValue = (event.target as HTMLSelectElement).value;
    this.riskDeclarationService.saveSelectedValue(Number(selectedValue)).subscribe();
  }
}

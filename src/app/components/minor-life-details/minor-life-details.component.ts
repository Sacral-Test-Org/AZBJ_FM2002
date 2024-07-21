import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InsuredPersonComponent } from '../insured-person/insured-person.component';

@Component({
  selector: 'app-minor-life-details',
  templateUrl: './minor-life-details.component.html',
  styleUrls: ['./minor-life-details.component.css']
})
export class MinorLifeDetailsComponent implements OnInit {
  classStandard: string;
  fathersAnnualIncome: number;
  mothersAnnualIncome: number;
  v_IP_MINOR_QST_FLAG: boolean;

  constructor(private router: Router, private insuredPersonComponent: InsuredPersonComponent) {}

  ngOnInit(): void {
    // Initialize the component and set up any necessary data bindings.
  }

  onBack(): void {
    this.backButtonHandler();
  }

  backButtonHandler(): void {
    this.v_IP_MINOR_QST_FLAG = this.insuredPersonComponent.getIPMinorQstFlag();
    this.navigateBack();
  }

  navigateBack(): void {
    this.router.navigate(['/previous-screen']);
  }
}

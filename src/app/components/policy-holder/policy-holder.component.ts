import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyHolderService } from 'src/app/services/policy-holder.service';
import { InsuredPersonService } from 'src/app/services/insured-person.service';

@Component({
  selector: 'app-policy-holder',
  templateUrl: './policy-holder.component.html',
  styleUrls: ['./policy-holder.component.css']
})
export class PolicyHolderComponent implements OnInit {
  constructor(
    private router: Router,
    private policyHolderService: PolicyHolderService,
    private insuredPersonService: InsuredPersonService
  ) {}

  ngOnInit(): void {
    this.getOccupationStatuses();
  }

  onPremiumRecdButtonClick(): void {
    this.router.navigate(['susac.dummy1']);
  }

  updatePolicyHolderDetails(insuredPersonDetails: any): void {
    // Logic to update policy holder details with insured person details
    // Disable certain fields
    this.disableFields();
  }

  disableFields(): void {
    // Logic to disable certain fields
  }

  enableFields(): void {
    // Logic to enable certain fields
  }

  handleSpouseDetailsInput(spouseName: string, spouseSurname: string, spouseDOB: string): void {
    spouseName = spouseName.toUpperCase().slice(0, 80);
    spouseSurname = spouseSurname.toUpperCase().slice(0, 40);
    const dobRegex = /^\d{2}\/\d{2}\/\d{4}$/;
    if (!dobRegex.test(spouseDOB)) {
      throw new Error('Invalid date format. Please use 
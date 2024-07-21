import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-old-policy-details',
  templateUrl: './old-policy-details.component.html',
  styleUrls: ['./old-policy-details.component.css']
})
export class OldPolicyDetailsComponent implements OnInit {

  previousPolicyNumber: string;
  policyholderName: string;
  partnerId: string;
  panNumber: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
    // Initialize component and fetch old policy details if necessary.
    this.previousPolicyNumber = '123456789';
    this.policyholderName = 'John Doe';
    this.partnerId = 'P123456';
    this.panNumber = 'ABCDE1234F';
  }

  onExit(): void {
    // Handle the exit button click event to close the old policy details section.
    this.router.navigate(['/new-business']);
  }

  onExitButtonClick(): void {
    // The method will use Angular Router to navigate to the New Business section.
    this.router.navigate(['/new-business']);
  }
}

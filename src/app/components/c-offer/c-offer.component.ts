import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-c-offer',
  templateUrl: './c-offer.component.html',
  styleUrls: ['./c-offer.component.css']
})
export class COfferComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    // Initialize the component and load existing rider information.
  }

  onCloseButtonClick(): void {
    // Navigate to the covers section and hide the offer window.
    this.router.navigate(['/covers']);
  }

  addRider(): void {
    // Logic to add a new rider entry.
  }

  removeRider(): void {
    // Logic to remove an existing rider entry.
  }

  navigateToRevisedOfferDetails(): void {
    // Logic to navigate to the revised offer details component.
    this.router.navigate(['/revised-offer-details']);
  }

  backButtonHandler(): void {
    // Navigate to the covers section and hide the C_OFFER window.
    this.router.navigate(['/covers']);
  }
}

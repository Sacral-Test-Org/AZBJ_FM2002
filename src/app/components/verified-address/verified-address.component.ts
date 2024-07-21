import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VerifiedAddressService } from 'src/app/services/verified-address.service';

@Component({
  selector: 'app-verified-address',
  templateUrl: './verified-address.component.html',
  styleUrls: ['./verified-address.component.css']
})
export class VerifiedAddressComponent implements OnInit {
  constructor(private router: Router, private verifiedAddressService: VerifiedAddressService) {}

  ngOnInit(): void {
    // Initialize the component and ensure the Verified Address button is hidden.
    const verifiedAddressButton = document.getElementById('verifiedAddressButton');
    if (verifiedAddressButton) {
      verifiedAddressButton.style.display = 'none';
    }
  }

  exit(): void {
    // Close the address verification section.
    this.router.navigate(['/insured-person']);
  }

  onExitButtonClick(): void {
    // When the 'Exit' button is clicked, navigate to the Insured Person section and hide the Verified Address section.
    this.exit();
  }

  onVerifiedAddressButtonClick(): void {
    // This method will be triggered when the 'Verified Address' button is clicked.
    this.verifiedAddressService.verifyAddress().subscribe(
      (response) => {
        console.log('Address verified successfully', response);
      },
      (error) => {
        console.error('Error verifying address', error);
      }
    );
  }
}

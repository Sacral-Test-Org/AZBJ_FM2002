import { Component, OnInit } from '@angular/core';
import { SignatureConfidenceService } from 'src/app/services/signature-confidence.service';
import { SignatureConfidence } from 'src/app/models/signature-confidence.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signature-confidence',
  templateUrl: './signature-confidence.component.html',
  styleUrls: ['./signature-confidence.component.css']
})
export class SignatureConfidenceComponent implements OnInit {
  signatureConfidenceDetails: SignatureConfidence[] = [];

  constructor(
    private signatureConfidenceService: SignatureConfidenceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getSignatureConfidenceDetails();
  }

  getSignatureConfidenceDetails(): void {
    this.signatureConfidenceService.getSignatureConfidenceDetails().subscribe(
      (data: SignatureConfidence[]) => {
        this.displaySignatureConfidenceDetails(data);
      },
      (error) => {
        console.error('Error fetching signature confidence details', error);
      }
    );
  }

  displaySignatureConfidenceDetails(signatureConfidenceDetails: SignatureConfidence[]): void {
    this.signatureConfidenceDetails = signatureConfidenceDetails;
    if (this.signatureConfidenceDetails.length > 0) {
      this.router.navigate([`/signature-confidence/${this.signatureConfidenceDetails[0].id}`]);
    }
  }

  onExit(): void {
    this.router.navigate(['/']);
  }

  onMasterSignature(): void {
    this.handleMasterSignatureButtonPress();
  }

  handleMasterSignatureButtonPress(): void {
    const params = {
      type: 'NB',
      category: 'MASTER_SIGN',
      id: this.getVerificationOrSignCardNumber()
    };
    this.signatureConfidenceService.generateSecureUrl(params).subscribe(
      (url: string) => {
        if (url) {
          window.open(url, '_blank');
        }
      },
      (error) => {
        console.error('Error generating secure URL', error);
      }
    );
  }

  private getVerificationOrSignCardNumber(): string {
    // Logic to get the verification number or sign card number
    // This is a placeholder implementation
    return '123456';
  }
}

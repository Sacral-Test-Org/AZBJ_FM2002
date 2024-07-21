import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

interface SurrogateIncomeProof {
  id: number;
  type: string;
  details: string;
}

@Component({
  selector: 'app-surrogate-income-proof',
  templateUrl: './surrogate-income-proof.component.html',
  styleUrls: ['./surrogate-income-proof.component.css']
})
export class SurrogateIncomeProofComponent implements OnInit {
  surrogateIncomeProofs: SurrogateIncomeProof[] = [];
  selectedSurrogateIncomeProof: SurrogateIncomeProof | null = null;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.loadSurrogateIncomeProofs();
  }

  loadSurrogateIncomeProofs(): void {
    this.http.get<SurrogateIncomeProof[]>('/api/surrogate-income-proofs').subscribe(
      data => this.surrogateIncomeProofs = data,
      error => this.logger.error('Error loading surrogate income proofs', error)
    );
  }

  onSelect(surrogateIncomeProof: SurrogateIncomeProof): void {
    this.selectedSurrogateIncomeProof = surrogateIncomeProof;
    this.displaySurrogateIncomeProofDetail(surrogateIncomeProof);
    this.navigateToSurrogateIncomeProofType();
  }

  displaySurrogateIncomeProofDetail(surrogateIncomeProof: SurrogateIncomeProof): void {
    // Logic to display the detailed view for the selected surrogate income proof
    this.logger.info('Displaying details for surrogate income proof', surrogateIncomeProof);
    // Assuming there's a detailed view component or section to show the details
    // This could be a modal or a separate section in the current component
  }

  navigateToSurrogateIncomeProofType(): void {
    // Logic to navigate to the surrogate income proof type field within the detailed view
    this.logger.info('Navigating to surrogate income proof type field');
    // Assuming there's a way to focus or scroll to the specific field
    // This could be done using Angular's ViewChild or ElementRef
  }
}

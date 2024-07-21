import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReinsuranceDetailsService } from 'src/app/services/reinsurance-details.service';
import { ReinsuranceDetails, ReinsurerDetails, Reinsurer } from 'src/app/models/reinsurance-details.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reinsurance-details',
  templateUrl: './reinsurance-details.component.html',
  styleUrls: ['./reinsurance-details.component.css']
})
export class ReinsuranceDetailsComponent implements OnInit {
  reinsuranceDetails: ReinsuranceDetails[] = [];
  reinsurerDetails: ReinsurerDetails[] = [];

  constructor(
    private reinsuranceDetailsService: ReinsuranceDetailsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchReinsuranceDetails();
    this.fetchReinsurerDetails();
  }

  fetchReinsuranceDetails(): void {
    this.reinsuranceDetailsService.getReinsuranceDetails().subscribe(
      (details: ReinsuranceDetails[]) => {
        this.reinsuranceDetails = details;
      },
      (error) => {
        console.error('Error fetching reinsurance details', error);
      }
    );
  }

  fetchReinsurerDetails(): void {
    this.reinsuranceDetailsService.getReinsurerDetails().subscribe(
      (details: ReinsurerDetails[]) => {
        this.reinsurerDetails = details;
      },
      (error) => {
        console.error('Error fetching reinsurer details', error);
      }
    );
  }

  referToReinsurer(reinsurerDetail: ReinsurerDetails): void {
    this.reinsuranceDetailsService.referToReinsurer(reinsurerDetail).subscribe(
      () => {
        console.log('Referred to reinsurer successfully');
      },
      (error) => {
        console.error('Error referring to reinsurer', error);
      }
    );
  }

  backButtonHandler(): void {
    this.router.navigate(['/covers']);
  }

  deleteRecord(recordId: number): void {
    this.reinsuranceDetailsService.deleteRecord(recordId).subscribe(
      () => {
        console.log('Record deleted successfully');
        this.fetchReinsuranceDetails(); // Refresh the list after deletion
      },
      (error) => {
        console.error('Error deleting record', error);
      }
    );
  }

  onReinsCodeDoubleClick(reinsuranceType: string, productId: string): void {
    if (reinsuranceType !== 'AUTO') {
      this.reinsuranceDetailsService.getReinsurerCodes(reinsuranceType, productId).subscribe(
        (reinsurers: Reinsurer[]) => {
          console.log('Reinsurer codes fetched successfully', reinsurers);
          // Logic to display the reinsurer codes in a list of values (LOV)
        },
        (error) => {
          console.error('Error fetching reinsurer codes', error);
        }
      );
    }
  }
}
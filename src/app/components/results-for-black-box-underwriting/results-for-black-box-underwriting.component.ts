import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ResultsForBlackBoxUnderwritingService } from 'src/app/services/results-for-black-box-underwriting.service';
import { Result } from 'src/app/models/result.model';

@Component({
  selector: 'app-results-for-black-box-underwriting',
  templateUrl: './results-for-black-box-underwriting.component.html',
  styleUrls: ['./results-for-black-box-underwriting.component.css']
})
export class ResultsForBlackBoxUnderwritingComponent implements OnInit {
  results: Result[] = [];
  displayedColumns: string[] = ['rowNumber', 'questionText', 'resultStatus', 'actionRequired'];

  constructor(
    private resultsService: ResultsForBlackBoxUnderwritingService,
    public dialogRef: MatDialogRef<ResultsForBlackBoxUnderwritingComponent>
  ) { }

  ngOnInit(): void {
    this.fetchResults();
  }

  fetchResults(): void {
    this.resultsService.getResults().subscribe((data: Result[]) => {
      this.results = data;
    });
  }

  checkRecordsAndFormQst(): void {
    if (this.results.length === 0 || this.results.some(result => !result.formQst)) {
      // Navigate to MED_UW section
      // Assuming there's a method in the service to handle this navigation
      this.resultsService.navigateToMedUw();
    }
  }
}

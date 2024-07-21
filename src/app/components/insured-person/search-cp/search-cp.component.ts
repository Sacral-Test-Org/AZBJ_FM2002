import { Component, Input, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-search-cp',
  templateUrl: './search-cp.component.html',
  styleUrls: ['./search-cp.component.css']
})
export class SearchCpComponent implements OnInit {
  @Input() searchResults: any;

  constructor(private logger: NGXLogger) { }

  ngOnInit(): void {
    this.displaySearchResults(this.searchResults);
  }

  displaySearchResults(searchResults: any): void {
    if (!searchResults) {
      this.logger.warn('No search results to display');
      return;
    }

    // Logic to display search results
    // Assuming searchResults is an array of customer partner information
    searchResults.forEach((result: any) => {
      // Display each result
      console.log('Customer Partner ID:', result.partnerId);
      console.log('Customer Partner Name:', result.partnerName);
      // Add more fields as necessary
    });

    this.logger.info('Search results displayed successfully');
  }
}

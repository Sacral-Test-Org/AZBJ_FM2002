import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-list-of-values',
  templateUrl: './list-of-values.component.html',
  styleUrls: ['./list-of-values.component.css']
})
export class ListOfValuesComponent {
  values: any[] = [];
  selectedValue: any;

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  displayList(): void {
    this.logger.info('Checking for help information...');
    // Simulate help check
    const helpAvailable = true;

    if (helpAvailable) {
      this.logger.info('Help information available. Fetching list of values...');
      this.http.get<any[]>('api/values').subscribe(
        (data) => {
          this.values = data;
          this.logger.info('List of values fetched successfully.');
        },
        (error) => {
          this.logger.error('Error fetching list of values:', error);
        }
      );
    } else {
      this.logger.warn('Help information not available.');
    }
  }

  selectValue(value: any): void {
    this.selectedValue = value;
    this.logger.info('Value selected:', value);
  }
}

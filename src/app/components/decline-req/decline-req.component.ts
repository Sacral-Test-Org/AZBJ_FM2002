import { Component, OnInit } from '@angular/core';
import { DeclineReqService } from 'src/app/services/decline-req.service';
import { TestNumberDTO } from 'src/app/models/test-number-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-decline-req',
  templateUrl: './decline-req.component.html',
  styleUrls: ['./decline-req.component.css']
})
export class DeclineReqComponent implements OnInit {
  validTestNumbers: TestNumberDTO[] = [];

  constructor(private declineReqService: DeclineReqService) { }

  ngOnInit(): void {
    // Initialization logic if needed
  }

  fetchValidTestNumbers(): void {
    this.declineReqService.fetchValidTestNumbers().subscribe(
      (data: TestNumberDTO[]) => {
        this.validTestNumbers = data;
        this.displayTestNumbers();
      },
      (error) => {
        console.error('Error fetching valid test numbers', error);
      }
    );
  }

  displayTestNumbers(): void {
    // Logic to display the list of valid test numbers
    console.log('Valid Test Numbers:', this.validTestNumbers);
  }

  onTestNumberFieldInteraction(): void {
    this.fetchValidTestNumbers();
  }
}

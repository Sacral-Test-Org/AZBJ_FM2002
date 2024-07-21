import { Component, OnInit } from '@angular/core';
import { CftService } from 'src/app/services/cft.service';

@Component({
  selector: 'app-cft',
  templateUrl: './cft.component.html',
  styleUrls: ['./cft.component.css']
})
export class CFTComponent implements OnInit {

  constructor(private cftService: CftService) { }

  ngOnInit(): void {
    this.resetFields();
    this.displayFirstRecord();
  }

  resetFields(): void {
    // Logic to reset all fields in the CFT section to their initial state
    this.cftService.resetCFTData();
  }

  displayFirstRecord(): void {
    // Logic to retrieve and display the first record in the CFT block
    this.cftService.getFirstRecord().subscribe(record => {
      // Display the record in the UI
      console.log(record); // Replace with actual display logic
    }, error => {
      console.error('Error retrieving first record:', error);
    });
  }
}

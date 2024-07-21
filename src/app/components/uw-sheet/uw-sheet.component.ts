import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-uw-sheet',
  templateUrl: './uw-sheet.component.html',
  styleUrls: ['./uw-sheet.component.css']
})
export class UwSheetComponent implements OnInit {
  rectNo: string = '12345';
  agentCode: string = 'A123';
  policyHolder: string = 'John Doe';
  insuredPersonBmi: number = 22.5;
  policyHolderBmi: number = 24.0;

  constructor() { }

  ngOnInit(): void {
    // Initialize the component and set the fields to read-only
  }
}

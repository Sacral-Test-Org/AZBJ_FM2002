import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SusacService } from 'src/app/services/susac.service';

@Component({
  selector: 'app-susac',
  templateUrl: './susac.component.html',
  styleUrls: ['./susac.component.css']
})
export class SusacComponent implements OnInit {
  susacData: any[] = [];
  totalSusac: number = 0;
  v_canvas_adj: string = 'N'; // This should be dynamically set based on your application logic

  constructor(private susacService: SusacService, private router: Router) {}

  ngOnInit(): void {
    // Assuming susacService.getSusacData() returns an observable with the SUSAC data
    this.susacService.getSusacData().subscribe(data => {
      this.susacData = data;
      this.calculateTotalSusac();
    });
  }

  calculateTotalSusac(): void {
    this.totalSusac = this.susacData.reduce((total, item) => total + item.SA_AMT, 0);
  }

  closeSection(): void {
    this.closeButtonHandler();
  }

  closeButtonHandler(): void {
    if (this.v_canvas_adj === 'Y') {
      // Hide current window and view
      // Display "Alert List" window and view
      // Move focus to "Alert" block and "Cancel" button within "Control" block
      // Set v_canvas_adj to 'N'
      this.v_canvas_adj = 'N';
      // Logic to display "Alert List" window and view
      this.router.navigate(['/alert-list']);
    } else {
      // Hide current window and view
      // Navigate to "Covers" tab
      // Move focus to "Covers" block
      this.router.navigate(['/covers']);
    }
  }
}
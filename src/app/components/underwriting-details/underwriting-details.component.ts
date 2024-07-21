import { Component, OnInit } from '@angular/core';
import { UnderwritingDetailsService } from 'src/app/services/underwriting-details.service';
import { UnderwritingDetail } from 'src/app/models/underwriting-detail.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-underwriting-details',
  templateUrl: './underwriting-details.component.html',
  styleUrls: ['./underwriting-details.component.css']
})
export class UnderwritingDetailsComponent implements OnInit {
  underwritingDetails: UnderwritingDetail[] = [];
  displayedDetails: UnderwritingDetail[] = [];
  currentPage: number = 0;
  pageSize: number = 5;

  constructor(private underwritingDetailsService: UnderwritingDetailsService) { }

  ngOnInit(): void {
    this.getUnderwritingDetails();
  }

  getUnderwritingDetails(): void {
    this.underwritingDetailsService.getUnderwritingDetails().subscribe((details: UnderwritingDetail[]) => {
      this.underwritingDetails = details;
      this.updateDisplayedDetails();
    });
  }

  updateDisplayedDetails(): void {
    const start = this.currentPage * this.pageSize;
    const end = start + this.pageSize;
    this.displayedDetails = this.underwritingDetails.slice(start, end);
  }

  nextPage(): void {
    if ((this.currentPage + 1) * this.pageSize < this.underwritingDetails.length) {
      this.currentPage++;
      this.updateDisplayedDetails();
    }
  }

  previousPage(): void {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.updateDisplayedDetails();
    }
  }

  addUnderwritingDetail(detail: UnderwritingDetail): void {
    this.underwritingDetailsService.addUnderwritingDetail(detail).subscribe((newDetail: UnderwritingDetail) => {
      this.underwritingDetails.push(newDetail);
      this.updateDisplayedDetails();
    });
  }

  updateUnderwritingDetail(detail: UnderwritingDetail): void {
    this.underwritingDetailsService.updateUnderwritingDetail(detail).subscribe((updatedDetail: UnderwritingDetail) => {
      const index = this.underwritingDetails.findIndex(d => d.underwritingNumber === updatedDetail.underwritingNumber);
      if (index !== -1) {
        this.underwritingDetails[index] = updatedDetail;
        this.updateDisplayedDetails();
      }
    });
  }
}

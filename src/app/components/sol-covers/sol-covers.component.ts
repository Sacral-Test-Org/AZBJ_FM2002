import { Component, OnInit } from '@angular/core';
import { SolCoversService } from 'src/app/services/sol-covers.service';
import { SolCoverheadService } from 'src/app/services/sol-coverhead.service';
import { SolCovers } from 'src/app/models/sol-covers.model';

@Component({
  selector: 'app-sol-covers',
  templateUrl: './sol-covers.component.html',
  styleUrls: ['./sol-covers.component.css']
})
export class SolCoversComponent implements OnInit {
  solCovers: SolCovers[] = [];
  sumAssured: number = 0;

  constructor(private solCoversService: SolCoversService, private solCoverheadService: SolCoverheadService) {}

  ngOnInit(): void {
    this.fetchAllRecords();
  }

  fetchAllRecords(): void {
    this.solCoversService.getAllRecords().subscribe((records: SolCovers[]) => {
      this.solCovers = records;
    });
  }

  updateSumInsured(sumAssured: number): void {
    this.solCovers.forEach((record) => {
      record.sumInsuredWholeCover = sumAssured;
      this.solCoversService.updateRecord(record).subscribe();
    });
  }

  updateCoversBlock(benefitTerm: number, premiumTerm: number): void {
    this.solCoversService.updateCovers(benefitTerm, premiumTerm).subscribe();
  }

  setTotalRiderInvest(): void {
    this.solCoversService.getCoverCode().subscribe((coverCode: string) => {
      if (coverCode.startsWith('L')) {
        this.solCovers.forEach((record) => {
          record.totalRiderInvest = this.sumAssured;
          record.readOnly = true;
        });
      }
    });
  }

  processRecords(): void {
    this.solCovers.forEach((record) => {
      if (record.coverCode.startsWith('R') && record.coverCode !== 'R036A01') {
        record.sumInsuredWholeCover = this.calculateSumInsured(record);
        this.solCoversService.updateRecord(record).subscribe();
      }
      if (record.coverCode === 'R036A01') {
        if (confirm('Do you want the Waver of Premium Benefit?')) {
          this.solCoversService.deleteRecord(record.id).subscribe();
        }
      }
    });
  }

  deleteCover(coverId: string): void {
    const cover = this.solCovers.find((c) => c.id === coverId);
    if (cover && cover.coverCode.startsWith('R') && this.isCompulsoryWithPackage(cover)) {
      alert('This cover is compulsory with the selected package and cannot be deleted.');
      return;
    }
    this.solCoversService.deleteCover(coverId).subscribe();
  }

  private calculateSumInsured(record: SolCovers): number {
    // Implement the specific formula for calculating sum insured
    return 0; // Placeholder
  }

  private isCompulsoryWithPackage(cover: SolCovers): boolean {
    // Implement the logic to check if the cover is compulsory with the selected package
    return false; // Placeholder
  }
}

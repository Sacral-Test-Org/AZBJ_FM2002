import { Component, OnInit } from '@angular/core';
import { SolCoverheadService } from 'src/app/services/sol-coverhead.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discountOptions: string[] = [];
  selectedDiscount: string | null = null;

  constructor(private solCoverheadService: SolCoverheadService) { }

  ngOnInit(): void {
    this.solCoverheadService.getDiscountOptions().subscribe((options: string[]) => {
      this.discountOptions = options;
    });
  }

  selectDiscountOption(discountOption: string): void {
    this.selectedDiscount = discountOption;
  }
}

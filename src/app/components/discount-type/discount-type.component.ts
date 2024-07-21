import { Component, OnInit } from '@angular/core';
import { DiscountTypeService } from 'src/app/services/discount-type.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-discount-type',
  templateUrl: './discount-type.component.html',
  styleUrls: ['./discount-type.component.css']
})
export class DiscountTypeComponent implements OnInit {
  discountType: string | null = null;

  constructor(private discountTypeService: DiscountTypeService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.determineDiscountType();
  }

  determineDiscountType(): void {
    this.discountTypeService.getDiscountType().subscribe(
      (data: any) => {
        this.discountType = data.discountType;
        this.logger.info('Discount type determined:', this.discountType);
      },
      (error: any) => {
        this.logger.error('Error determining discount type:', error);
      }
    );
  }
}

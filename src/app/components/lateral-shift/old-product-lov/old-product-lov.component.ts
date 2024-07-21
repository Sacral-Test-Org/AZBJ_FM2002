import { Component } from '@angular/core';
import { LateralShiftService } from 'src/app/services/lateral-shift.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-old-product-lov',
  templateUrl: './old-product-lov.component.html',
  styleUrls: ['./old-product-lov.component.css']
})
export class OldProductLovComponent {
  oldProducts: any[] = [];
  selectedProduct: string = '';

  constructor(private lateralShiftService: LateralShiftService, private logger: NGXLogger) {}

  showOldProductLOV(): void {
    this.lateralShiftService.fetchOldProductData().subscribe(
      (data: any[]) => {
        this.oldProducts = data;
        this.logger.info('Old products fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching old products', error);
      }
    );
  }

  selectValue(selectedValue: string): void {
    this.selectedProduct = selectedValue;
    this.populateOldProductField(selectedValue);
    this.logger.info('Selected product', selectedValue);
  }

  populateOldProductField(value: string): void {
    // Logic to populate the Old Product field in the parent component
    // This method should be implemented in the parent component and called here
  }
}

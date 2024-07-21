import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LateralShiftService } from 'src/app/services/lateral-shift.service';
import { OldProductLovComponent } from './old-product-lov/old-product-lov.component';

@Component({
  selector: 'app-lateral-shift',
  templateUrl: './lateral-shift.component.html',
  styleUrls: ['./lateral-shift.component.css']
})
export class LateralShiftComponent {
  totalRecords: number = 0;
  oldProduct: string = '';

  constructor(private router: Router, private lateralShiftService: LateralShiftService) {}

  saveButtonHandler(): void {
    // Navigate to the Lateral Shift data section
    this.router.navigate(['/lateral-shift-data-section']).then(() => {
      // Identify the total number of records in the Lateral Shift data section
      this.totalRecords = this.lateralShiftService.getTotalRecords();
      // Return to the first record in the Lateral Shift data section
      this.lateralShiftService.navigateToFirstRecord();
    });
  }

  handleOldProductDoubleClick(): void {
    // Show the list of values (LOV) for old products
    const oldProductLov = new OldProductLovComponent(this.lateralShiftService);
    oldProductLov.showOldProductLOV().then((selectedValue: string) => {
      this.populateOldProductField(selectedValue);
    });
  }

  populateOldProductField(selectedValue: string): void {
    // Populate the "Old Product" field with the selected value from the LOV
    this.oldProduct = selectedValue;
  }
}

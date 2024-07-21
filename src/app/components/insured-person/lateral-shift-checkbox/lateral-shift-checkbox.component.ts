import { Component, Input } from '@angular/core';
import { InsuredPersonService } from 'src/app/services/insured-person.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-lateral-shift-checkbox',
  templateUrl: './lateral-shift-checkbox.component.html',
  styleUrls: ['./lateral-shift-checkbox.component.css']
})
export class LateralShiftCheckboxComponent {
  @Input() insuredPersonId: string;
  @Input() partnerName: string;

  constructor(private insuredPersonService: InsuredPersonService, private logger: NGXLogger) {}

  handleCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    const isChecked = checkbox.checked;

    this.insuredPersonService.getLateralShiftByInsuredPersonId(this.insuredPersonId).subscribe(
      (lateralShift) => {
        if (lateralShift) {
          if (isChecked) {
            lateralShift.flag = 'Y';
            this.insuredPersonService.updateLateralShiftStatus(this.insuredPersonId, lateralShift).subscribe(
              () => this.logger.info('Lateral shift status updated to Y'),
              (error) => this.logger.error('Error updating lateral shift status', error)
            );
          } else {
            this.insuredPersonService.deleteLateralShift(this.insuredPersonId).subscribe(
              () => this.logger.info('Lateral shift record deleted'),
              (error) => this.logger.error('Error deleting lateral shift record', error)
            );
          }
        } else if (isChecked) {
          const newLateralShift = { insuredPersonId: this.insuredPersonId, shiftNumber: 1, partnerName: this.partnerName, flag: 'Y' };
          this.insuredPersonService.createLateralShift(newLateralShift).subscribe(
            () => this.logger.info('New lateral shift record created'),
            (error) => this.logger.error('Error creating new lateral shift record', error)
          );
        }
      },
      (error) => this.logger.error('Error fetching lateral shift data', error)
    );
  }
}

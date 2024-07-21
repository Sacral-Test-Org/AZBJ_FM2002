import { Component, Input } from '@angular/core';
import { PolicyMemberService } from 'src/app/services/policy-member.service';
import { LateralShiftDTO } from 'src/app/models/lateral-shift-dto.model';
import { NGXLogger } from 'ngx-logger';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lateral-shift-checkbox',
  templateUrl: './lateral-shift-checkbox.component.html',
  styleUrls: ['./lateral-shift-checkbox.component.css']
})
export class LateralShiftCheckboxComponent {
  @Input() policyMember: any;

  constructor(private policyMemberService: PolicyMemberService, private logger: NGXLogger) {}

  onCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    const isChecked = checkbox.checked;

    const lateralShiftDTO: LateralShiftDTO = {
      partnerId: this.policyMember.partnerId,
      ipNumber: this.policyMember.ipNumber,
      name: this.policyMember.name,
      flag: isChecked ? 'Y' : 'N'
    };

    this.policyMemberService.updateLateralShiftStatus(lateralShiftDTO).subscribe(
      response => {
        this.logger.info('Lateral shift status updated successfully', response);
      },
      error => {
        this.logger.error('Error updating lateral shift status', error);
      }
    );
  }
}

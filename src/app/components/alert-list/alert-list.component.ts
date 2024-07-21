import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertListService } from 'src/app/services/alert-list.service';
import { ValidationResponse } from 'src/app/models/validation-response.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-alert-list',
  templateUrl: './alert-list.component.html',
  styleUrls: ['./alert-list.component.css']
})
export class AlertListComponent implements OnInit {
  radioGroupValue: string = 'X';
  modalRef: NgbModalRef;
  proceedButtonEnabled: boolean = false;

  constructor(private modalService: NgbModal, private alertListService: AlertListService) {}

  ngOnInit(): void {
    this.radioGroupValue = 'X';
  }

  openModal(content): void {
    this.modalRef = this.modalService.open(content, { centered: true, backdrop: 'static', keyboard: false });
    this.modalRef.result.then((result) => {
      // Handle close result
    }, (reason) => {
      // Handle dismiss reason
    });
  }

  validateOptions(options: { backdating: string, dispatch: string, receipt: string, premium: string, rider: string, excessPremium: string, mobile: string }): void {
    this.alertListService.validateOptions(options).subscribe((response: ValidationResponse) => {
      if (response.isValid) {
        this.proceedButtonEnabled = true;
        if (options.premium === 'Y') {
          this.navigateToField('excessPremium');
        } else {
          this.clearBlock();
          this.setAction('W');
          this.updatePolicyStatus();
          this.navigateToField('insuredPerson');
          this.modalRef.close();
        }
      } else {
        this.proceedButtonEnabled = false;
      }
    });
  }

  navigateToField(field: string): void {
    // Logic to navigate to the specified field
  }

  private clearBlock(): void {
    // Logic to clear the block
  }

  private setAction(action: string): void {
    // Logic to set the action
  }

  private updatePolicyStatus(): void {
    // Logic to update the policy status
  }
}
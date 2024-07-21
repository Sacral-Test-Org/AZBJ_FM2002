import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SomDetailsService } from 'src/app/services/som-details.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-som-details',
  templateUrl: './som-details.component.html',
  styleUrls: ['./som-details.component.css']
})
export class SomDetailsComponent implements OnInit {
  somDetailsForm: FormGroup;
  somId: string;
  hubId: string;
  hubInchargeName: string;
  somName: string;
  sendToHubHead: boolean = false;

  constructor(
    private fb: FormBuilder,
    private somDetailsService: SomDetailsService,
    private logger: NGXLogger
  ) {
    this.somDetailsForm = this.fb.group({
      somId: [{ value: '', disabled: true }],
      hubId: [{ value: '', disabled: true }],
      hubInchargeName: [{ value: '', disabled: true }],
      somName: [{ value: '', disabled: true }],
      sendToHubHead: [false]
    });
  }

  ngOnInit(): void {
    this.getSomDetails();
  }

  getSomDetails(): void {
    this.somDetailsService.getSomDetails().subscribe(
      (data) => {
        this.somId = data.somId;
        this.hubId = data.hubId;
        this.hubInchargeName = data.hubInchargeName;
        this.somName = data.somName;
        this.somDetailsForm.patchValue({
          somId: this.somId,
          hubId: this.hubId,
          hubInchargeName: this.hubInchargeName,
          somName: this.somName
        });
      },
      (error) => {
        this.logger.error('Error fetching SOM details', error);
      }
    );
  }

  onCancel(): void {
    this.somDetailsForm.reset();
  }

  onSubmit(): void {
    if (this.sendToHubHead) {
      this.somDetailsService.getHubInchargeDetails(this.hubId, this.somId).subscribe(
        (data) => {
          if (data) {
            this.hubId = data.hubId;
            this.hubInchargeName = data.hubInchargeName;
          } else {
            this.hubId = null;
            this.hubInchargeName = null;
          }
        },
        (error) => {
          this.logger.error('Error fetching hub incharge details', error);
        }
      );
    }
    this.somDetailsService.submitSomDetails(this.somDetailsForm.value).subscribe(
      (response) => {
        this.logger.info('SOM details submitted successfully', response);
      },
      (error) => {
        this.logger.error('Error submitting SOM details', error);
      }
    );
  }

  hideWindowAndView(): void {
    // Logic to hide the current window and associated view
    const currentWindow = window;
    currentWindow.document.body.style.visibility = 'hidden';
  }

  onCancelButtonClick(): void {
    this.hideWindowAndView();
  }

  okButtonClickHandler(): void {
    this.somDetailsService.validateFlag(this.somId).subscribe(
      (flag) => {
        if (flag !== 'Y') {
          alert('SOM is not present. Please refer to the Hub Incharge for approval.');
        } else {
          this.somDetailsService.updateProposalStatus(this.somId, 'FR-AR', 'F').subscribe(
            (response) => {
              this.logger.info('Proposal status updated successfully', response);
              this.hideWindowAndView();
            },
            (error) => {
              this.logger.error('Error updating proposal status', error);
            }
          );
        }
      },
      (error) => {
        this.logger.error('Error validating flag', error);
      }
    );
  }

  onCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    this.sendToHubHead = checkbox.checked;
    if (this.sendToHubHead) {
      this.somDetailsService.getHubInchargeDetails(this.hubId, this.somId).subscribe(
        (data) => {
          if (data) {
            this.hubId = data.hubId;
            this.hubInchargeName = data.hubInchargeName;
          } else {
            this.hubId = null;
            this.hubInchargeName = null;
          }
        },
        (error) => {
          this.logger.error('Error fetching hub incharge details', error);
        }
      );
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { SaveService } from 'src/app/services/save.service';
import { InsuredPersonService } from 'src/app/services/insured-person.service';
import { Router } from '@angular/router';
import { SeniorUnderwriterDTO } from 'src/app/models/senior-underwriter-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-save',
  templateUrl: './save.component.html',
  styleUrls: ['./save.component.css']
})
export class SaveComponent implements OnInit {
  selectedAction: string = 'RW';
  status: string = 'IM';
  seniorUnderwriters: SeniorUnderwriterDTO[] = [];
  reason: string = '';

  constructor(private saveService: SaveService, private insuredPersonService: InsuredPersonService, private router: Router) {}

  ngOnInit(): void {
    this.setDefaultValue();
    const storedAction = this.saveService.getSelectedAction();
    if (storedAction) {
      this.selectedAction = storedAction;
    }
  }

  onActionChange(event: Event): void {
    const action = (event.target as HTMLInputElement).value;
    this.selectedAction = action;
    this.saveService.setSelectedAction(action);
  }

  setDefaultValue(): void {
    this.status = 'IM';
  }

  handleRadioButtonChange(event: Event): void {
    this.status = (event.target as HTMLInputElement).value;
  }

  onSeniorUnderwriterClick(): void {
    this.saveService.fetchSeniorUnderwriters().subscribe(
      (data: SeniorUnderwriterDTO[]) => {
        this.seniorUnderwriters = data;
      },
      (error) => {
        console.error('Error fetching senior underwriters', error);
      }
    );
  }

  onCancel(): void {
    this.saveService.setActionStatus('W');
    this.saveService.updatePolicyStatusFromSOFA();
    this.insuredPersonService.navigateToInsuredPerson();
    this.router.navigate(['/insured-person']);
  }

  handleActionSelection(action: string): void {
    this.saveService.updateStatus(action).subscribe(
      (response) => {
        if (action === 'ISSUED') {
          this.status = 'IM';
        } else if (action === 'REJECTED' || action === 'DECLINED') {
          this.status = 'RM';
        } else {
          this.status = null;
        }
      },
      (error) => {
        console.error('Error updating status', error);
      }
    );
  }

  exitButtonHandler(): void {
    if (!this.reason) {
      this.saveService.setExitReasonFlag('N');
    }
    this.router.navigate(['/end-movement']);
  }

  onSaveButtonClick(): void {
    if (!this.reason) {
      alert('Please enter reason for Save & Exit and proceed.');
      return;
    }
    this.saveService.saveReason(this.reason).subscribe(
      (response) => {
        this.reason = '';
        alert('Reason saved successfully, please continue.');
        this.router.navigate(['/next-block']);
      },
      (error) => {
        console.error('Error saving reason', error);
      }
    );
  }
}

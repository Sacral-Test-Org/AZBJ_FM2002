import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DeclineService } from 'src/app/services/decline.service';

@Component({
  selector: 'app-decline',
  templateUrl: './decline.component.html',
  styleUrls: ['./decline.component.css']
})
export class DeclineComponent implements OnInit {
  declineForm: FormGroup;
  titles: string[] = ['Mr', 'Mrs', 'Ms', 'Dr'];
  subclassBusinesses: string[] = ['Business1', 'Business2', 'Business3', 'Business4', 'Business5'];
  declineReasons: any[] = [];
  districts: string[] = [];

  constructor(private fb: FormBuilder, private declineService: DeclineService) { }

  ngOnInit(): void {
    this.declineForm = this.fb.group({
      fatherTitle: ['', Validators.required],
      fatherFirstName: ['', Validators.required],
      fatherMiddleName: [''],
      fatherSurname: ['', [Validators.required, Validators.maxLength(50)]],
      nomineeTitle: ['', Validators.required],
      nomineeFirstName: ['', Validators.required],
      nomineeMiddleName: [''],
      nomineeSurname: ['', [Validators.required, Validators.maxLength(50)]],
      subclassBusiness: ['', Validators.required],
      cofferAmount: ['', Validators.required],
      remarks: ['', [Validators.required, Validators.maxLength(100)]],
      city: ['', [Validators.required, Validators.maxLength(40)]],
      declinedReason: ['', [Validators.required, Validators.maxLength(150)]],
      comments: ['', Validators.maxLength(255)]
    });
  }

  addRequirement(): void {
    // Logic for adding a requirement
    console.log('Add Requirement button clicked');
  }

  exitForm(): void {
    const declineCode = this.declineForm.get('declinedReason').value;
    const comments = this.declineForm.get('comments').value;
    if (declineCode === '03' && !comments) {
      alert('Please provide comments.');
      this.declineForm.get('comments').setErrors({ required: true });
      return;
    }
    // Logic to navigate to the next section and hide the current window
    console.log('Exit button clicked');
  }

  validateInput(): boolean {
    if (this.declineForm.invalid) {
      alert('Please fill all required fields correctly.');
      return false;
    }
    return true;
  }

  saveDetails(): void {
    if (this.validateInput()) {
      this.declineService.saveDeclineDetails(this.declineForm.value).subscribe(response => {
        console.log('Details saved successfully');
      }, error => {
        console.error('Error saving details', error);
      });
    }
  }

  handleDropdownSelection(event: Event): void {
    const selectedTitle = (event.target as HTMLSelectElement).value;
    console.log('Selected Title:', selectedTitle);
  }

  onCityFieldDoubleClick(): void {
    const state = 'SomeState'; // This should be dynamically set based on user input
    this.declineService.fetchDistrictNames(state).subscribe(districts => {
      this.districts = districts;
      console.log('Districts fetched:', this.districts);
    }, error => {
      console.error('Error fetching districts', error);
    });
  }

  handleTitleSelection(selectedTitle: string): void {
    console.log('Selected Title:', selectedTitle);
  }

  exitButtonHandler(): void {
    const declineCode = this.declineForm.get('declinedReason').value;
    const comments = this.declineForm.get('comments').value;
    if (declineCode === '03' && !comments) {
      alert('Please provide comments.');
      this.declineForm.get('comments').setErrors({ required: true });
      return;
    }
    this.navigateToNextSection();
  }

  navigateToNextSection(): void {
    console.log('Navigating to the next section');
    // Logic to hide the current window and update form status
  }

  handleDropdownChange(event: Event): void {
    const selectedValue = (event.target as HTMLSelectElement).value.toUpperCase();
    console.log('Selected Value:', selectedValue);
  }

  onReasonFieldDoubleClick(): void {
    this.declineService.fetchDeclineReasons().subscribe(reasons => {
      this.declineReasons = reasons;
      console.log('Decline Reasons fetched:', this.declineReasons);
    }, error => {
      console.error('Error fetching decline reasons', error);
    });
  }

  onReasonSelect(reasonCode: string): void {
    if (reasonCode === '03') {
      this.declineForm.get('comments').enable();
    } else {
      this.declineForm.get('comments').disable();
    }
  }
}

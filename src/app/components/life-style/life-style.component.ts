import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LifeStyleService } from 'src/app/services/life-style.service';

@Component({
  selector: 'app-life-style',
  templateUrl: './life-style.component.html',
  styleUrls: ['./life-style.component.css']
})
export class LifeStyleComponent implements OnInit {
  lifeStyleForm: FormGroup;
  formStatus: string = 'S';

  constructor(private fb: FormBuilder, private lifeStyleService: LifeStyleService) { }

  ngOnInit(): void {
    this.lifeStyleForm = this.fb.group({
      questionId: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      questionDescription: ['', [Validators.required, Validators.maxLength(2000)]],
      value: ['', [Validators.required, Validators.maxLength(2000), Validators.pattern('^[A-Z]*$')]],
      result: ['', [Validators.required, Validators.pattern('^[YN]$')]]
    });
  }

  onValueChange(event: Event): void {
    const questionId = this.lifeStyleForm.get('questionId')?.value;
    if (questionId === 16 || questionId === 17) {
      this.formStatus = 'N';
    }
  }

  submitForm(): void {
    if (this.lifeStyleForm.valid) {
      // Handle form submission logic here
      console.log('Form Submitted', this.lifeStyleForm.value);
    }
  }

  updateLifestyleStatus(productId: number, primaryStatus: string, secondaryStatus: string): void {
    this.lifeStyleService.updateStatus(productId, primaryStatus, secondaryStatus).subscribe(response => {
      console.log('Status updated', response);
      // Update the UI based on the response
    });
  }
}
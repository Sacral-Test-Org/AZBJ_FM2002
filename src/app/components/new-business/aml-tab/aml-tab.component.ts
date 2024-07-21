import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-aml-tab',
  templateUrl: './aml-tab.component.html',
  styleUrls: ['./aml-tab.component.css']
})
export class AmlTabComponent implements OnInit {
  amlForm: FormGroup;
  partnerOptions: string[] = ['Partner 1', 'Partner 2', 'Partner 3'];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.amlForm = this.fb.group({
      partnerSelection: [{ value: this.partnerOptions[0], disabled: true }]
    });
  }
}

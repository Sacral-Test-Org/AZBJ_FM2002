import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-add-senior-underwriter',
  templateUrl: './add-senior-underwriter.component.html',
  styleUrls: ['./add-senior-underwriter.component.css']
})
export class AddSeniorUnderwriterComponent implements OnInit {
  @ViewChild('userIdInput') userIdInput: ElementRef;

  constructor(private logger: NGXLogger) { }

  ngOnInit(): void {
    this.focusOnUserIdInput();
  }

  private focusOnUserIdInput(): void {
    try {
      this.userIdInput.nativeElement.focus();
    } catch (error) {
      this.handleError(error);
    }
  }

  private handleError(error: any): void {
    this.logger.error('Error displaying the Add Senior Underwriter view', error);
    alert('An error occurred while displaying the view. Please try again later.');
  }
}

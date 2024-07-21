import { Component, OnInit } from '@angular/core';
import { ValidationErrorListService } from 'src/app/services/validation-error-list.service';
import { ValidationError } from 'src/app/models/validation-error.model';
import { ValidationItem } from 'src/app/models/validation-item.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-validation-error-list',
  templateUrl: './validation-error-list.component.html',
  styleUrls: ['./validation-error-list.component.css']
})
export class ValidationErrorListComponent implements OnInit {
  validationErrors: ValidationError[] = [];

  constructor(private validationErrorListService: ValidationErrorListService, private router: Router) {}

  ngOnInit(): void {
    this.validationErrorListService.fetchValidationErrors().subscribe((errors: ValidationError[]) => {
      this.validationErrors = errors;
    });
  }

  closeErrorList(): void {
    // Logic to close the error list modal window
    // This can be implemented using a modal service or any other method based on your modal implementation
  }

  navigateToValidationItem(blockName: string, itemName: string): void {
    this.validationErrorListService.fetchValidationItem(blockName, itemName).subscribe((item: ValidationItem) => {
      this.router.navigate(['/validation-list-item', item.id]);
    });
  }

  onErrorCodeDoubleClick(errorCode: string): void {
    // Logic to handle double-click on error code and navigate to the corresponding item
    // Assuming errorCode can be used to fetch blockName and itemName
    const error = this.validationErrors.find(err => err.errorCode === errorCode);
    if (error) {
      this.navigateToValidationItem(error.blockName, error.itemName);
    }
  }
}

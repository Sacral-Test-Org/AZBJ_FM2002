import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-validation-list',
  templateUrl: './validation-list.component.html',
  styleUrls: ['./validation-list.component.css']
})
export class ValidationListComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private logger: NGXLogger) { }

  ngOnInit(): void {
    // Initialization logic if needed
  }

  navigateToValidationItem(errorCode: string): void {
    this.logger.debug('Navigating to validation item with error code:', errorCode);
    // Assuming the validation list items have routes like '/validation-list/:errorCode'
    this.router.navigate(['/validation-list', errorCode]);
  }
}

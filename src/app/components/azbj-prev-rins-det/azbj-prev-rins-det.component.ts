import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-azbj-prev-rins-det',
  templateUrl: './azbj-prev-rins-det.component.html',
  styleUrls: ['./azbj-prev-rins-det.component.css']
})
export class AzbjPrevRinsDetComponent {
  constructor(private router: Router) {}

  onExitButtonClick(): void {
    this.router.navigate(['/reinsurance']);
  }
}

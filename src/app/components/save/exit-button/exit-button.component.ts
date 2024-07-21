import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-exit-button',
  templateUrl: './exit-button.component.html',
  styleUrls: ['./exit-button.component.css']
})
export class ExitButtonComponent {
  sv_ex_rsn: string = '';
  sv_ex_rsn_flg: string = 'Y';

  constructor(private router: Router, private logger: NGXLogger) {}

  exitButtonHandler(): void {
    try {
      if (!this.sv_ex_rsn) {
        this.sv_ex_rsn_flg = 'N';
      }
      this.hideCurrentWindowAndCanvas();
      this.navigateToEndMovement();
    } catch (error) {
      this.logger.error('Error during exit button handling', error);
    }
  }

  private hideCurrentWindowAndCanvas(): void {
    // Logic to hide the current window and canvas
    const currentWindow = document.getElementById('currentWindow');
    const currentCanvas = document.getElementById('currentCanvas');
    if (currentWindow) {
      currentWindow.style.display = 'none';
    }
    if (currentCanvas) {
      currentCanvas.style.display = 'none';
    }
  }

  private navigateToEndMovement(): void {
    this.router.navigate(['/end-movement']).then(() => {
      const actionItem = document.getElementById('actionItem');
      if (actionItem) {
        actionItem.focus();
      }
    });
  }
}
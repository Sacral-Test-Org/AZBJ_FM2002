import { Component } from '@angular/core';
import { WNrFurService } from 'src/app/services/w-nr-fur.service';

@Component({
  selector: 'app-w-nr-fur',
  templateUrl: './w-nr-fur.component.html',
  styleUrls: ['./w-nr-fur.component.css']
})
export class WNrFurComponent {
  comments: string = '';
  frResRecd: string = '';
  errorMessage: string = '';
  tooltipMessage: string = 'Please enter at least 10 characters.';

  constructor(private wNrFurService: WNrFurService) {}

  validateComments(comments: string): boolean {
    if (comments && comments.length < 10) {
      this.errorMessage = 'Comments should not be less than 10 characters.';
      return false;
    }
    this.errorMessage = '';
    return true;
  }

  showTooltip(event: MouseEvent): void {
    // Logic to display tooltip
    const tooltip = document.createElement('div');
    tooltip.className = 'tooltip';
    tooltip.innerText = this.tooltipMessage;
    tooltip.style.position = 'absolute';
    tooltip.style.top = `${event.clientY + 10}px`;
    tooltip.style.left = `${event.clientX + 10}px`;
    document.body.appendChild(tooltip);

    const removeTooltip = () => {
      document.body.removeChild(tooltip);
    };

    event.target?.addEventListener('mouseleave', removeTooltip, { once: true });
    event.target?.addEventListener('dblclick', removeTooltip, { once: true });
  }

  onNavigateNext(): void {
    this.wNrFurService.setDateCalled(new Date());
  }

  onFRResRecdChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    const value = target.value;
    if (value === 'Y' || value === 'N') {
      this.wNrFurService.validateFRResRecd(value).subscribe(
        (userId) => {
          this.wNrFurService.setFrReqRaisedBy(userId);
        },
        (error) => {
          this.errorMessage = 'An error occurred while validating FR_RES_RECD field.';
        }
      );
    } else {
      this.errorMessage = 'Invalid value for FR_RES_RECD field.';
    }
  }

  onKeyDown(event: KeyboardEvent): void {
    if (event.key === 'ArrowDown') {
      if (this.frResRecd === 'N' || this.frResRecd === 'Y') {
        this.wNrFurService.handleKeyDown(this.frResRecd).subscribe(
          () => {
            this.wNrFurService.deleteCurrentRecord();
          },
          (error) => {
            this.errorMessage = 'An error occurred while processing the down arrow key.';
          }
        );
      } else {
        this.wNrFurService.moveToNextRecord();
      }
    }
  }

  onKeyUp(event: KeyboardEvent): void {
    if (event.key === 'ArrowUp') {
      if (this.frResRecd === 'N' || this.frResRecd === 'Y') {
        this.wNrFurService.handleKeyUp(this.frResRecd).subscribe(
          () => {
            this.wNrFurService.deleteCurrentRecord();
          },
          (error) => {
            this.errorMessage = 'An error occurred while processing the up arrow key.';
          }
        );
      } else {
        this.wNrFurService.moveToPreviousRecord();
      }
    }
  }
}

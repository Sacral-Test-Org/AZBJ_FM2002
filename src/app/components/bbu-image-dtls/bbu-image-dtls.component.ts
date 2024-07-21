import { Component, OnInit } from '@angular/core';
import { BbuImageDtlsService } from 'src/app/services/bbu-image-dtls.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-bbu-image-dtls',
  templateUrl: './bbu-image-dtls.component.html',
  styleUrls: ['./bbu-image-dtls.component.css']
})
export class BbuImageDtlsComponent implements OnInit {
  private zoomFactor: number = 1;
  private currentX: number = 0;
  private currentY: number = 0;
  private currentZ: number = 1;

  constructor(private bbuImageDtlsService: BbuImageDtlsService, private logger: NGXLogger) {}

  ngOnInit(): void {
    // Initialize the component and fetch the necessary data to display BBU Image Details.
    this.logger.debug('BBU Image Details component initialized');
  }

  validateAnswer(answer: string): void {
    if (answer === 'Y' || answer === 'N') {
      this.bbuImageDtlsService.validateAnswer(answer);
    } else {
      alert('Please enter Y for Yes or N for No');
    }
  }

  zoomImage(): void {
    this.zoomFactor *= -1; // Toggle zoom factor
    const canvas = document.getElementById('CAN_BBU_IMAGE') as HTMLCanvasElement;
    if (canvas) {
      const context = canvas.getContext('2d');
      if (context) {
        context.scale(this.zoomFactor, this.zoomFactor);
        this.logger.debug('Image zoomed', { zoomFactor: this.zoomFactor });
      }
    }
  }

  scrollImage(imageId: string, currentX: number, currentY: number, scrollFactor: number, offset: number, currentZ: number): void {
    this.currentX += scrollFactor;
    this.currentY += scrollFactor;
    const canvas = document.getElementById('CAN_BBU_IMAGE') as HTMLCanvasElement;
    if (canvas) {
      const context = canvas.getContext('2d');
      if (context) {
        context.translate(this.currentX, this.currentY);
        this.logger.debug('Image scrolled', { currentX: this.currentX, currentY: this.currentY });
      }
    }
  }

  viewQuestions(): void {
    // Logic to handle viewing questions, navigate to the BBU Image Details section, and display the BBU Image window.
    this.logger.debug('View Questions button clicked');
    // Navigate to BBU Image Details section and display the BBU Image window.
  }
}
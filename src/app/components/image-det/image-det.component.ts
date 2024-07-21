import { Component } from '@angular/core';
import { ImageDetService } from 'src/app/services/image-det.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-image-det',
  templateUrl: './image-det.component.html',
  styleUrls: ['./image-det.component.css']
})
export class ImageDetComponent {
  constructor(private imageDetService: ImageDetService, private logger: NGXLogger) {}

  onAccessWebSalesProposalClick(): void {
    this.imageDetService.getWebSalesProposalUrl().subscribe(
      (url: string) => {
        if (url) {
          window.open(url, '_blank');
        } else {
          this.logger.error('URL is null or undefined');
        }
      },
      (error) => {
        this.logger.error('Error retrieving the Web Sales Proposal URL', error);
      }
    );
  }
}

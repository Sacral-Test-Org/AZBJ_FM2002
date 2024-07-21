import { Component } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-image-interaction',
  templateUrl: './image-interaction.component.html',
  styleUrls: ['./image-interaction.component.css']
})
export class ImageInteractionComponent {
  public images: any[] = [
    { src: 'image1.jpg', zoom: 1, position: { top: 0, left: 0 }, additionalInfoVisible: false },
    { src: 'image2.jpg', zoom: 1, position: { top: 0, left: 0 }, additionalInfoVisible: false },
    { src: 'image3.jpg', zoom: 1, position: { top: 0, left: 0 }, additionalInfoVisible: false }
  ];
  private currentImageSet: number = 0;

  constructor(private logger: NGXLogger) {}

  navigateLeft(index: number): void {
    this.images[index].position.left -= 10;
    this.logger.debug(`Image ${index} moved left`);
  }

  navigateRight(index: number): void {
    this.images[index].position.left += 10;
    this.logger.debug(`Image ${index} moved right`);
  }

  navigateUp(index: number): void {
    this.images[index].position.top -= 10;
    this.logger.debug(`Image ${index} moved up`);
  }

  navigateDown(index: number): void {
    this.images[index].position.top += 10;
    this.logger.debug(`Image ${index} moved down`);
  }

  zoomIn(index: number): void {
    this.images[index].zoom += 0.1;
    this.logger.debug(`Image ${index} zoomed in`);
  }

  zoomOut(index: number): void {
    this.images[index].zoom -= 0.1;
    this.logger.debug(`Image ${index} zoomed out`);
  }

  resetZoom(index: number): void {
    this.images[index].zoom = 1;
    this.logger.debug(`Image ${index} zoom reset`);
  }

  printImage(index: number): void {
    const printWindow = window.open('', '_blank');
    printWindow.document.write(`<img src="${this.images[index].src}" style="width:100%" />`);
    printWindow.print();
    printWindow.close();
    this.logger.debug(`Image ${index} print initiated`);
  }

  nextImageSet(): void {
    this.currentImageSet++;
    this.logger.debug(`Navigated to next image set: ${this.currentImageSet}`);
  }

  previousImageSet(): void {
    this.currentImageSet--;
    this.logger.debug(`Navigated to previous image set: ${this.currentImageSet}`);
  }

  toggleAdditionalInfo(index: number): void {
    this.images[index].additionalInfoVisible = !this.images[index].additionalInfoVisible;
    this.logger.debug(`Image ${index} additional info visibility toggled`);
  }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-bbu-image',
  templateUrl: './bbu-image.component.html',
  styleUrls: ['./bbu-image.component.css']
})
export class BbuImageComponent {
  imageId: string = 'image1';
  currentX: number = 0;
  currentY: number = 0;
  scrollFactor: number = 10;
  zFactor: number = 1;

  scrollImage(imageId: string, currentX: number, currentY: number, scrollFactor: number, zFactor: number): void {
    const imageElement = document.getElementById(imageId);
    if (imageElement) {
      const newX = currentX + scrollFactor;
      const newY = currentY + scrollFactor;
      imageElement.style.transform = `translate(${newX}px, ${newY}px) scale(${zFactor})`;
    }
  }

  onScrollButtonClick(): void {
    this.scrollImage(this.imageId, this.currentX, this.currentY, this.scrollFactor, this.zFactor);
  }

  scrollImageLeft(): void {
    const leftScrollFactor = this.scrollFactor * -1;
    this.currentX += leftScrollFactor;
    this.scrollImage(this.imageId, this.currentX, this.currentY, 0, this.zFactor);
  }

  zoomImage(): void {
    const globalZoomFactor = 1.2;
    this.zFactor *= globalZoomFactor;
    this.scrollImage(this.imageId, this.currentX, this.currentY, 0, this.zFactor);
  }

  onZoomButtonClick(): void {
    this.zoomImage();
  }

  navigateToPreviousImage(): void {
    // Logic to navigate to the previous image
    this.currentX = 0;
    this.currentY = 0;
    this.zFactor = 1;
    // Update the image source or other related parameters here
  }

  scrollImageUp(): void {
    const upScrollFactor = this.scrollFactor * -1;
    this.currentY += upScrollFactor;
    this.scrollImage(this.imageId, this.currentX, this.currentY, 0, this.zFactor);
  }

  scrollImageRight(): void {
    this.currentX += this.scrollFactor;
    this.scrollImage(this.imageId, this.currentX, this.currentY, 0, this.zFactor);
  }

  printImage(): void {
    const imageName = 'currentImageName'; // This should be retrieved from a global variable or state
    console.log(`Printing image: ${imageName}`);
    // Logic to print the image
  }

  resetImageZoom(): void {
    this.zFactor = 1;
    this.scrollImage(this.imageId, this.currentX, this.currentY, 0, this.zFactor);
  }

  hideQuestionsButton(): void {
    // Logic to hide the BBU Image window
    const isItemEnabled = true; // This should be determined by the actual item status
    if (isItemEnabled) {
      this.navigateToAgents();
    } else {
      this.navigateToCovers();
    }
  }

  navigateToAgents(): void {
    // Logic to navigate to the AGENTS block
  }

  navigateToCovers(): void {
    // Logic to navigate to the COVERS block
  }
}

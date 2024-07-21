import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ViewImageService } from 'src/app/services/view-image.service';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-view-image',
  templateUrl: './view-image.component.html',
  styleUrls: ['./view-image.component.css']
})
export class ViewImageComponent implements OnInit {
  imagePath: string;
  proposalNumber: string;
  currentImage: HTMLImageElement;
  zoomFactor: number = 1;

  constructor(
    private http: HttpClient,
    private router: Router,
    private viewImageService: ViewImageService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    // Initialization logic if needed
  }

  displayImage(imagePath: string, proposalNumber: string): void {
    this.imagePath = imagePath;
    this.proposalNumber = proposalNumber;
    const clientPath = `C:/temp/${proposalNumber}/${imagePath}`;
    this.logger.info(`Displaying image from path: ${clientPath}`);

    this.http.get(clientPath, { responseType: 'blob' }).subscribe(
      (response: Blob) => {
        const url = window.URL.createObjectURL(response);
        const isPdf = imagePath.endsWith('.pdf');
        if (isPdf) {
          window.open(url, '_blank');
        } else {
          const img = new Image();
          img.src = url;
          document.body.appendChild(img);
          this.currentImage = img;
        }
      },
      (error) => {
        this.logger.error('Error displaying image', error);
        alert('Error displaying image');
      }
    );
  }

  onViewButtonClick(): void {
    const policyNumber = this.proposalNumber;
    if (policyNumber) {
      this.viewImageService.viewImage(policyNumber).subscribe(
        (url: string) => {
          if (url) {
            window.open(url, '_blank');
          } else {
            this.handleError('Invalid URL');
          }
        },
        (error) => this.handleError(error)
      );
    } else {
      this.handleError('Policy number is null');
    }
  }

  onImagesButtonClick(): void {
    const policyNumber = this.proposalNumber;
    if (policyNumber) {
      this.viewImageService.generateUrl(policyNumber).subscribe(
        (url: string) => {
          if (url) {
            window.open(url, '_blank');
          } else {
            this.handleError('Invalid URL');
          }
        },
        (error) => this.handleError(error)
      );
    } else {
      this.handleError('Policy number is null');
    }
  }

  handleError(error: any): void {
    this.logger.error('An error occurred', error);
    alert('An error occurred: ' + error);
  }

  markSignatureMismatch(imageId: string): void {
    this.viewImageService.markMismatch(imageId).subscribe(
      () => this.logger.info('Marked signature mismatch for imageId: ' + imageId),
      (error) => this.handleError(error)
    );
  }

  onViewAllImagesClick(): void {
    this.router.navigate(['/view-all-images']);
  }

  navigateLeft(): void {
    this.currentImage.style.left = `${parseInt(this.currentImage.style.left || '0') - 10}px`;
  }

  navigateRight(): void {
    this.currentImage.style.left = `${parseInt(this.currentImage.style.left || '0') + 10}px`;
  }

  navigateUp(): void {
    this.currentImage.style.top = `${parseInt(this.currentImage.style.top || '0') - 10}px`;
  }

  navigateDown(): void {
    this.currentImage.style.top = `${parseInt(this.currentImage.style.top || '0') + 10}px`;
  }

  zoomIn(): void {
    this.zoomFactor += 0.1;
    this.currentImage.style.transform = `scale(${this.zoomFactor})`;
  }

  zoomOut(): void {
    this.zoomFactor -= 0.1;
    this.currentImage.style.transform = `scale(${this.zoomFactor})`;
  }

  resetZoom(): void {
    this.zoomFactor = 1;
    this.currentImage.style.transform = 'scale(1)';
  }

  printImage(): void {
    const printWindow = window.open('', '_blank');
    printWindow.document.write(this.currentImage.outerHTML);
    printWindow.print();
  }

  nextImageSet(): void {
    // Logic to navigate to the next set of images
  }

  previousImageSet(): void {
    // Logic to navigate to the previous set of images
  }

  toggleAdditionalInfo(): void {
    const infoElement = document.getElementById('additional-info');
    if (infoElement) {
      infoElement.style.display = infoElement.style.display === 'none' ? 'block' : 'none';
    }
  }

  zoomImage(currentImage: HTMLImageElement, zoomFactor: number): void {
    const width = currentImage.width * zoomFactor;
    const height = currentImage.height * zoomFactor;
    currentImage.style.width = `${width}px`;
    currentImage.style.height = `${height}px`;
  }

  onViewImageClick(): void {
    this.displayImage(this.imagePath, this.proposalNumber);
  }

  navigateToNextImage(): void {
    // Logic to navigate to the next image
    this.currentImage.style.left = '0';
    this.currentImage.style.top = '0';
    this.zoomFactor = 1;
    this.currentImage.style.transform = 'scale(1)';
  }
}

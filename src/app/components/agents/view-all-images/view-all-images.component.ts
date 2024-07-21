import { Component, OnInit } from '@angular/core';
import { ViewImageService } from 'src/app/services/view-image.service';
import { ImageRecord } from 'src/app/models/image-record.model';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-view-all-images',
  templateUrl: './view-all-images.component.html',
  styleUrls: ['./view-all-images.component.css']
})
export class ViewAllImagesComponent implements OnInit {
  private imageRecords: ImageRecord[] = [];
  private currentIndex: number = 0;

  constructor(private viewImageService: ViewImageService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.viewImageService.getImageRecords().subscribe(
      (records: ImageRecord[]) => {
        this.imageRecords = records;
        this.displayNextImage();
      },
      (error) => {
        this.logger.error('Error fetching image records', error);
      }
    );
  }

  onViewAllImagesClick(): void {
    this.viewImageService.fetchImageDetails().subscribe(
      (response) => {
        this.logger.info('Image details fetched successfully', response);
        this.ngOnInit(); // Re-fetch and display images
      },
      (error) => {
        this.logger.error('Error fetching image details', error);
      }
    );
  }

  private displayNextImage(): void {
    if (this.currentIndex < this.imageRecords.length) {
      const currentImage = this.imageRecords[this.currentIndex];
      // Logic to display the image
      this.logger.info('Displaying image', currentImage);
      this.currentIndex++;
      setTimeout(() => this.displayNextImage(), 3000); // Display next image after 3 seconds
    } else {
      this.logger.info('All images have been displayed.');
    }
  }
}

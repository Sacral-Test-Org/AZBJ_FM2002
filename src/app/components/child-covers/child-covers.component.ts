import { Component, OnInit } from '@angular/core';
import { ChildCoverDetailsService } from 'src/app/services/child-cover-details.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-child-covers',
  templateUrl: './child-covers.component.html',
  styleUrls: ['./child-covers.component.css']
})
export class ChildCoversComponent implements OnInit {
  childCovers: any[] = [];

  constructor(private childCoverDetailsService: ChildCoverDetailsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.refreshChildCovers();
  }

  refreshChildCovers(): void {
    this.childCoverDetailsService.getChildCovers().subscribe(
      (data: any[]) => {
        this.childCovers = data;
        this.logger.info('Child covers data refreshed');
        this.setFocusToChildCovers();
      },
      (error) => {
        this.logger.error('Error refreshing child covers data', error);
      }
    );
  }

  setFocusToChildCovers(): void {
    const childCoversSection = document.getElementById('child-covers-section');
    if (childCoversSection) {
      childCoversSection.focus();
      this.logger.info('Focus set to child covers section');
    }
  }

  deleteChildCovers(): void {
    this.childCoverDetailsService.getChildCovers().subscribe(
      (data: any[]) => {
        this.childCovers = data;
        this.logger.info('Child covers data fetched for deletion');
        this.childCovers.forEach((cover) => {
          if (cover.markedForDeletion === 'Y') {
            this.childCoverDetailsService.deleteChildCover(cover.id).subscribe(
              () => {
                this.logger.info(`Child cover with id ${cover.id} deleted`);
              },
              (error) => {
                this.logger.error(`Error deleting child cover with id ${cover.id}`, error);
              }
            );
          }
        });
        this.refreshChildCovers();
      },
      (error) => {
        this.logger.error('Error fetching child covers data for deletion', error);
      }
    );
  }
}

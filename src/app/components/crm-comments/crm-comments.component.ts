import { Component, OnInit } from '@angular/core';
import { CrmCommentsService } from 'src/app/services/crm-comments.service';
import { LoggerService } from 'ngx-logger';

@Component({
  selector: 'app-crm-comments',
  templateUrl: './crm-comments.component.html',
  styleUrls: ['./crm-comments.component.css']
})
export class CrmCommentsComponent implements OnInit {
  comments: any[] = [];
  displayedComments: any[] = [];
  currentPage: number = 1;
  commentsPerPage: number = 8;

  constructor(private crmCommentsService: CrmCommentsService, private logger: LoggerService) {}

  ngOnInit(): void {
    this.fetchComments();
  }

  fetchComments(): void {
    this.crmCommentsService.getComments().subscribe(
      (data: any[]) => {
        this.comments = data;
        this.updateDisplayedComments();
      },
      (error) => {
        this.logger.error('Error fetching comments', error);
      }
    );
  }

  updateDisplayedComments(): void {
    const startIndex = (this.currentPage - 1) * this.commentsPerPage;
    const endIndex = startIndex + this.commentsPerPage;
    this.displayedComments = this.comments.slice(startIndex, endIndex);
  }

  nextPage(): void {
    if ((this.currentPage * this.commentsPerPage) < this.comments.length) {
      this.currentPage++;
      this.updateDisplayedComments();
    }
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updateDisplayedComments();
    }
  }
}
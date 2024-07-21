import { Component, OnInit } from '@angular/core';
import { UwCommentsService } from '../../services/uw-comments.service';
import { Comment } from '../../models/comment.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-uw-comments',
  templateUrl: './uw-comments.component.html',
  styleUrls: ['./uw-comments.component.css']
})
export class UwCommentsComponent implements OnInit {
  comments: Comment[] = [];

  constructor(private uwCommentsService: UwCommentsService) { }

  ngOnInit(): void {
    this.fetchComments();
  }

  addComment(comment: Comment): void {
    this.uwCommentsService.addComment(comment).subscribe(newComment => {
      this.comments.push(newComment);
    });
  }

  refreshComments(): void {
    this.fetchComments();
  }

  handleRefreshClick(): void {
    this.refreshComments();
  }

  fetchComments(): void {
    this.uwCommentsService.getComments().subscribe(comments => {
      this.comments = comments;
    });
  }
}

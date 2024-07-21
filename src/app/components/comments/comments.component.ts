import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
  @ViewChild('commentsSection') commentsSection: ElementRef;

  constructor() { }

  ngOnInit(): void {
  }

  focusCommentsSection(): void {
    if (this.commentsSection && this.commentsSection.nativeElement) {
      this.commentsSection.nativeElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
      this.commentsSection.nativeElement.focus();
    }
  }
}

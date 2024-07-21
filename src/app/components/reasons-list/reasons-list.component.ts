import { Component, OnInit } from '@angular/core';
import { ReasonsListService } from 'src/app/services/reasons-list.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reasons-list',
  templateUrl: './reasons-list.component.html',
  styleUrls: ['./reasons-list.component.css']
})
export class ReasonsListComponent implements OnInit {
  reasons: string[] = [];
  displayedReasons: string[] = [];
  maxDisplay: number = 6;

  constructor(private reasonsListService: ReasonsListService) {}

  ngOnInit(): void {
    this.reasonsListService.getReasons().subscribe((data: string[]) => {
      this.reasons = data.map(reason => reason.length > 200 ? reason.substring(0, 200) : reason);
      this.displayedReasons = this.reasons.slice(0, this.maxDisplay);
    });
  }

  scroll(event: Event): void {
    const element = event.target as HTMLElement;
    const scrollTop = element.scrollTop;
    const itemHeight = element.scrollHeight / this.reasons.length;
    const startIndex = Math.floor(scrollTop / itemHeight);
    this.displayedReasons = this.reasons.slice(startIndex, startIndex + this.maxDisplay);
  }
}
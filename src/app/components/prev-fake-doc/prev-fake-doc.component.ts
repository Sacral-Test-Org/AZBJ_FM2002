import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrevFakeDocService } from '../../services/prev-fake-doc.service';
import { FakeDocument } from '../../models/fake-document.model';

@Component({
  selector: 'app-prev-fake-doc',
  templateUrl: './prev-fake-doc.component.html',
  styleUrls: ['./prev-fake-doc.component.css']
})
export class PrevFakeDocComponent implements OnInit {
  fakeDocuments: FakeDocument[] = [];

  constructor(private prevFakeDocService: PrevFakeDocService, private router: Router) {}

  ngOnInit(): void {
    this.prevFakeDocService.getFakeDocuments().subscribe((data: FakeDocument[]) => {
      this.fakeDocuments = data;
    });
  }

  onView(documentId: string): void {
    // Logic to view the image associated with the document
    // This could be a modal popup or a new route depending on the application design
    console.log('View document with ID:', documentId);
  }

  onExit(): void {
    this.router.navigate(['/main-document-management']);
  }
}
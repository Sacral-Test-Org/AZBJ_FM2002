import { Component, Input } from '@angular/core';
import { DrcCategoryService } from 'src/app/services/drc-category.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-drc-category-editor',
  templateUrl: './drc-category-editor.component.html',
  styleUrls: ['./drc-category-editor.component.css']
})
export class DrcCategoryEditorComponent {
  @Input() currentContent: string;
  editorVisible: boolean = false;
  editorPosition: { x: number, y: number } = { x: 0, y: 0 };

  constructor(private drcCategoryService: DrcCategoryService) {}

  openEditor(position: { x: number, y: number }): void {
    this.editorPosition = position;
    this.editorVisible = true;
  }

  saveChanges(newValue: string): void {
    this.drcCategoryService.saveDrcCategory(newValue).subscribe(() => {
      this.currentContent = newValue;
      this.editorVisible = false;
    });
  }
}

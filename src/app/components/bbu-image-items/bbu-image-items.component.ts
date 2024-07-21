import { Component, OnInit } from '@angular/core';
import { BBUImageItemsService } from 'src/app/services/bbu-image-items.service';
import { BBUImageItem } from 'src/app/models/bbu-image-item.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-bbu-image-items',
  templateUrl: './bbu-image-items.component.html',
  styleUrls: ['./bbu-image-items.component.css']
})
export class BbuImageItemsComponent implements OnInit {
  bbuImageItems: BBUImageItem[] = [];
  originalItemValues: { [key: string]: any } = {};

  constructor(private bbuImageItemsService: BBUImageItemsService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.processBBUImageItems();
  }

  handleCheckboxChange(event: Event, item: BBUImageItem): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      if (item.change_allowed === 'N') {
        alert('Cannot Change The Value For This Item');
        checkbox.checked = false;
        item.new_item_value = this.originalItemValues[item.item_name];
      }
    }
  }

  processBBUImageItems(): void {
    this.bbuImageItemsService.getBBUImageItems().subscribe((items) => {
      this.bbuImageItems = items;
      this.bbuImageItems.forEach((item) => {
        this.originalItemValues[item.item_name] = item.new_item_value;
        if (item.value_change === 'Y') {
          item.item_name = item.new_item_value;
        }
      });
    });
  }

  handleCheckboxStateChange(event: Event, groupQuestionNumber: number, serialNumber: number, dependentQuestion: string): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      if (dependentQuestion && dependentQuestion !== '' && item.dependency_flag === 'N') {
        this.bbuImageItemsService.populateGroupQuestion(groupQuestionNumber, serialNumber, dependentQuestion);
      }
    } else {
      if (dependentQuestion && dependentQuestion !== '' && item.dependency_flag === 'N') {
        this.bbuImageItemsService.deleteGroupQuestion(groupQuestionNumber, serialNumber, dependentQuestion);
      }
    }
  }
}

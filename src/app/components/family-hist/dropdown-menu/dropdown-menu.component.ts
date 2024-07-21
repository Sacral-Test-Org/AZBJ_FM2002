import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-dropdown-menu',
  templateUrl: './dropdown-menu.component.html',
  styleUrls: ['./dropdown-menu.component.css']
})
export class DropdownMenuComponent {
  @Output() familyMemberSelected = new EventEmitter<string>();
  familyMembers: string[] = ['Father', 'Mother', 'Brother', 'Sister'];
  selectedFamilyMember: string = '';

  selectFamilyMember(familyMember: string): void {
    this.selectedFamilyMember = familyMember;
    this.familyMemberSelected.emit(this.selectedFamilyMember);
  }
}

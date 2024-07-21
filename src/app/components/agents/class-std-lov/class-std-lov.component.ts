import { Component, EventEmitter, Output } from '@angular/core';
import { AgentsService } from 'src/app/services/agents.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-class-std-lov',
  templateUrl: './class-std-lov.component.html',
  styleUrls: ['./class-std-lov.component.css']
})
export class ClassStdLovComponent {
  @Output() valueSelected = new EventEmitter<any>();
  lovData: any[] = [];

  constructor(private agentsService: AgentsService, private logger: NGXLogger) {}

  showLov(): void {
    this.agentsService.getClassStdLov().subscribe(
      (data) => {
        this.lovData = data;
        this.logger.info('LOV data fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching LOV data', error);
      }
    );
  }

  selectValue(value: any): void {
    this.valueSelected.emit(value);
    this.logger.info('Value selected from LOV', value);
  }
}

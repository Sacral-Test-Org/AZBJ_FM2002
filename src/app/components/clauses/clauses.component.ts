import { Component, OnInit } from '@angular/core';
import { ClausesService } from '../../services/clauses.service';
import { Clause } from '../../models/clause.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-clauses',
  templateUrl: './clauses.component.html',
  styleUrls: ['./clauses.component.css']
})
export class ClausesComponent implements OnInit {
  clauses: Clause[] = [];
  errorMessage: string = '';

  constructor(private clausesService: ClausesService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.getClauses();
  }

  getClauses(): void {
    this.clausesService.getClauses().subscribe(
      (data: Clause[]) => {
        this.clauses = data.slice(0, 3); // Display a maximum of three records
      },
      (error) => this.handleError(error)
    );
  }

  deleteClause(id: number): void {
    this.clausesService.deleteClause(id).subscribe(
      () => {
        this.clauses = this.clauses.filter(clause => clause.id !== id);
      },
      (error) => this.handleError(error)
    );
  }

  deleteRecord(clause: Clause, nationalId: string): void {
    if ((nationalId === 'FOREIGN NATIONAL' || nationalId === 'NRI') && clause.description === 'NRI Clause') {
      this.errorMessage = 'NRI Clause is mandatory for NRI/FOREIGN NATIONAL case';
      this.logger.error(this.errorMessage);
    } else {
      this.deleteClause(clause.id);
    }
  }

  handleError(error: any): void {
    this.errorMessage = 'An error occurred while processing your request.';
    this.logger.error(this.errorMessage, error);
  }
}

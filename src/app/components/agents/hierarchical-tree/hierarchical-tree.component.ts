import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-hierarchical-tree',
  templateUrl: './hierarchical-tree.component.html',
  styleUrls: ['./hierarchical-tree.component.css']
})
export class HierarchicalTreeComponent implements OnInit {
  treeData: any[] = [];

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.fetchTreeData();
  }

  fetchTreeData(): void {
    const branchCode = 'someBranchCode'; // Replace with actual branch code
    const agentCode = 'someAgentCode'; // Replace with actual agent code
    const url = `/api/agents/hierarchical-tree?branchCode=${branchCode}&agentCode=${agentCode}`;

    this.http.get<any[]>(url).subscribe(
      data => {
        this.treeData = data;
        this.renderTree(this.treeData);
      },
      error => {
        this.logger.error('Error fetching tree data', error);
      }
    );
  }

  renderTree(data: any[]): void {
    // Logic to render hierarchical tree using the data
    // This can be implemented using a tree library or custom logic
    console.log('Rendering tree with data:', data);
  }
}

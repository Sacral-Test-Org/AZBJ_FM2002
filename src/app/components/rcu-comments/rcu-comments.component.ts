import { Component, OnInit } from '@angular/core';
import { RcuCommentsService } from '../../services/rcu-comments.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-rcu-comments',
  templateUrl: './rcu-comments.component.html',
  styleUrls: ['./rcu-comments.component.css']
})
export class RcuCommentsComponent implements OnInit {
  policyNo: string;
  moduleName: string = 'BBU';
  comments$: Observable<any>;

  constructor(
    private rcuCommentsService: RcuCommentsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.policyNo = params['POLICY_NO'];
      this.fetchRcuComments();
    });
  }

  fetchRcuComments(): void {
    const params = {
      POLICY_NO: this.policyNo,
      MODULE_NAME: this.moduleName
    };
    this.comments$ = this.rcuCommentsService.getRcuComments(params);
  }
}

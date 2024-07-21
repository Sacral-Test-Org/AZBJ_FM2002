import { Component, OnInit } from '@angular/core';
import { BlockFundsService } from '../../services/block-funds.service';
import { Fund } from '../../models/fund.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-block-funds',
  templateUrl: './block-funds.component.html',
  styleUrls: ['./block-funds.component.css']
})
export class BlockFundsComponent implements OnInit {
  funds: Fund[] = [];

  constructor(private blockFundsService: BlockFundsService) { }

  ngOnInit(): void {
    this.blockFundsService.getFunds().subscribe((data: Fund[]) => {
      this.funds = data;
    });
  }

  getFunds(): Fund[] {
    return this.funds;
  }
}
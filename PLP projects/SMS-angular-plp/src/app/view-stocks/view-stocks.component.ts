import { Component, OnInit } from '@angular/core';
import { ManagerService } from '../manager.service';
import { Router } from '@angular/router';
import { InvesterServicesService } from '../invester-services.service';

@Component({
  selector: 'app-view-stocks',
  templateUrl: './view-stocks.component.html',
  styleUrls: ['./view-stocks.component.css']
})
export class ViewStocksComponent implements OnInit {
  message: string;
  stocks: Stock[];
  constructor(private investerService: InvesterServicesService) {
    this.viewAllStocks();
  }

  viewAllStocks() {
    this.investerService.viewStocks().subscribe(response => {
      console.log(response);
      this.stocks = response.stocks;
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}

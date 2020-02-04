import { Component, OnInit } from '@angular/core';
import { InvesterServicesService } from '../invester-services.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-stockinfo',
  templateUrl: './view-all-stockinfo.component.html',
  styleUrls: ['./view-all-stockinfo.component.css']
})
export class ViewAllStockinfoComponent implements OnInit {

  investerStockInfos: InvesterStockInfo[];
  investerDetails;
  message;
  error;

  constructor(private investerService: InvesterServicesService,
    private router: Router) {
    this.getInvesterStocksInfo();
  }

  getInvesterStocksInfo() {
    const investerDetails = JSON.parse(localStorage.getItem('investerDetails'));
    const investerID = investerDetails.investers[0].investerID;
    console.log('IM INVerterrrrrrIDDD,...:', investerID);

    console.log(investerID);

    this.investerService.viewMyStockInfo(investerID).subscribe(response => {
      console.log(response);
      this.investerStockInfos = response.investerInfo;
      console.log('SUCCESSSS..STOCK INFO FOUND');

    }, err => {
      console.log('FALIED STOCKS INFO NOT FOUND');
      console.log(err);
    });
  }

  sellStocks(investerInfoBean) {

    this.investerService.updateStocksBackToStockTable(investerInfoBean).subscribe(response => {
      console.log(response);
      if (response.message === 'Success') {
        this.message = 'The Stock Sold Out';
        setTimeout(() => {
          this.message = null;
        }, 3000);
        this.router.navigateByUrl('/congrats');
      } else {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
    });
  }

  ngOnInit() {
  }

}

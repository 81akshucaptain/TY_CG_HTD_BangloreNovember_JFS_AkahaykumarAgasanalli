import { Component, OnInit } from '@angular/core';
import { InvesterServicesService } from '../invester-services.service';

@Component({
  selector: 'app-view-all-stockinfo',
  templateUrl: './view-all-stockinfo.component.html',
  styleUrls: ['./view-all-stockinfo.component.css']
})
export class ViewAllStockinfoComponent implements OnInit {

  investerStockInfos: InvesterStockInfo[];
  investerDetails;
  constructor(private investerService: InvesterServicesService) {
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

  ngOnInit() {
  }

}

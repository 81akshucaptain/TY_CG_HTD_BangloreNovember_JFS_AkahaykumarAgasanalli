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
  stocks: Stocks[];
  constructor(private investerService: InvesterServicesService,
    private router: Router
  ) {
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
  selectedStocks(stockBean) {
    // this.customerService.selectedContractToUpdate = customerBean;
    // console.log(this.customerService.selectedContractToUpdate);
    const investerDetails = JSON.parse(localStorage.getItem('investerDetails'));
    console.log('IM INVETSERid FROM VIEW STOCKS:', investerDetails.investers[0].investerID);

    this.router.navigate([`/purchase-stocks/${stockBean.stockID}`],
      {
        queryParams: {
          investerID: investerDetails.investers[0].investerID,
          availableStocks: stockBean.availableStocks,
          companyName: stockBean.companyName,
          companyID: stockBean.companyID,
          purchasedPrice: stockBean.currentPrice,
          currentPrice: stockBean.currentPrice,
        }
      }
    );
  }

  ngOnInit() {
  }

}

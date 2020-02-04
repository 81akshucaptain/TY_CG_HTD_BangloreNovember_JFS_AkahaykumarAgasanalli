import { Component, OnInit } from '@angular/core';
import { InvesterServicesService } from '../invester-services.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-purchase-stocks',
  templateUrl: './purchase-stocks.component.html',
  styleUrls: ['./purchase-stocks.component.css']
})
export class PurchaseStocksComponent implements OnInit {
  stockID1: number;
  investerID1: number;
  companyName1: string;
  companyID1: number;
  purchasedPrice1: number;
  currentPrice1: number;
  availableStocks1: number;

  investerStockInfo: InvesterStockInfo[];
  message;
  avialableStocksForCheck;
  constructor(
    private investerService: InvesterServicesService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe(data => {
      console.log(data.stockID);
      this.stockID1 = data.stockID;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.investerID1 = data.investerID;
      this.companyName1 = data.companyName;
      this.companyID1 = data.companyID;
      this.purchasedPrice1 = data.purchasedPrice;
      this.currentPrice1 = data.currentPrice;
      this.availableStocks1 = data.availableStocks;
      this.avialableStocksForCheck = data.availableStocks;
    });
  }
  addInvesterStockInfo(form: NgForm) {
    console.log('STOCKS AVAILABLE: ', this.avialableStocksForCheck);
    console.log('Stocks DEMANDED: ', form.value.stocksVolume);


    if (this.avialableStocksForCheck > form.value.stocksVolume) {
      this.investerService.addInvesterStockPurchases(form.value).subscribe(res => {
        console.log(res);
        if (res.message === 'Success') {
          console.log('Purchased data added Successfuly');
          this.router.navigateByUrl('/view-all-invester-stock-info');
        }
        form.reset();
      });
    } else {
      this.message = 'PLEASE ENTER THE VALID STOCK, THAT IS LESS THAN AVAILABLE STOCKS';
      setTimeout(() => {
        this.message = null;
      }, 5000);
    }
  }
  ngOnInit() {
  }

}

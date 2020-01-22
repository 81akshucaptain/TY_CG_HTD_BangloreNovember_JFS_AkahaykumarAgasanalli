import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-view-contracts-by-scheduler',
  templateUrl: './view-contracts-by-scheduler.component.html',
  styleUrls: ['./view-contracts-by-scheduler.component.css']
})
export class ViewContractsBySchedulerComponent implements OnInit {
  contracts: Contracts[];
  message: string;
  productQuantity: number;
  contractMessage: string;

  constructor(
    private adminServices: AdminService,
    private router: Router
  ) {
    this.getContracts();

  }
  getContracts() {
    this.adminServices.viewContracts().subscribe(response => {
      console.log(response);
      this.contracts = response.contract;
    }, err => {
      console.log(err);
    });
  }

  deleteMessage() {
    this.message = this.message;
  }

  scheduleContract(contract) {
    this.adminServices.searchProduct(contract).subscribe(response => {
      console.log(response);
      localStorage.setItem('productDetails', JSON.stringify(response));
      console.log('productDetails   are in local storage');
      const productDetails = JSON.parse(localStorage.getItem('productDetails'));
      this.productQuantity = productDetails.product[0].quantity;
      if (this.productQuantity < contract.productId) {
        this.adminServices.canScheduleTheContract = true;
        this.router.navigateByUrl('/schedule-contracts');
      } else {
        this.adminServices.canScheduleTheContract = false;
        this.router.navigateByUrl('/schedule-contracts');

      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}

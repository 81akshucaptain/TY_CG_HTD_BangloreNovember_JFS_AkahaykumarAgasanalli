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
  status = 'ordered';

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
      this.adminServices.canScheduleTheContract1 = false;
      this.adminServices.canScheduleTheContract2 = false;
      localStorage.setItem('productDetails', JSON.stringify(response));
      console.log('productDetails are in local storage');
      const productDetails = JSON.parse(localStorage.getItem('productDetails'));
      // quantitiy from localStorage
      this.productQuantity = productDetails.product[0].quantity;
      console.log('IM QTY FROM LS: ', this.productQuantity);

      // quantity from form data
      let qty = contract.qunatity;
      console.log("IM QTY FROM FORM DATA", qty);

      if (qty <= this.productQuantity) {
        console.log('Im inside IF LOOP');

        // To Update Order Status
        this.adminServices.updateContractStatus(contract).subscribe(response => {
          console.log(response);
          if (response.message === 'Success') {
            console.log('Product Status Updated Successfuly');
            this.adminServices.canScheduleTheContract1 = true;
            this.router.navigateByUrl('/schedule-contracts');
          } else {
            console.log('FALIED TO UPDATE CONTRACT STATUS');
            this.router.navigateByUrl('/schedule-contracts');
          }
        });
      } else {
        console.log('RESPONSE FAILED TO COMPARE QTY');
        this.adminServices.canScheduleTheContract2 = true;
        console.log('CanUpdateIS: ', this.adminServices.canScheduleTheContract2);
        this.router.navigateByUrl('/schedule-contracts');
      }

    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}

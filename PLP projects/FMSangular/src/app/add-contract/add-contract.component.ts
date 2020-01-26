import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {
  error: string;
  message: string;
  productIds: string[];
  products: Products[];
  newDate;
  customerForCustomerValidation;
  constructor(
    private customerService: CustomerService,
    private adminService: AdminService,
    private router: Router) {
    this.customerForCustomerValidation = this.customerService.cudtomerIdForValidation;
    this.getProducts();
    const today = new Date();
    const date = today.getDate();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    if (today.getMonth() > 8) {
      this.newDate = year + '-' + month + '-' + date;
    } else {
      this.newDate = year + '-' + '0' + month + '-' + date;
    }
  }

  addContract(form: NgForm) {
    this.customerService.addContract(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'Contract Added Succesfully') {
        this.message = response.message;
        setTimeout(() => {
          this.message = null;
        }, 3000);
      } else {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
    });
  }
  getProducts() {
    this.adminService.viewProduct().subscribe(response => {
      this.products = response.product;
      console.log(this.products);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}

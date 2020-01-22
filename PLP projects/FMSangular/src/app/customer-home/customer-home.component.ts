import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  customers: Customers[];
  message: string;
  email: string;

  constructor(
    private adminServices: AdminService,
    private customerService: CustomerService,
    private router: Router
  ) {
    this.searchCustomers();
  }

  selectedCustomer(customerBean) {
    console.log(customerBean);
    this.adminServices.selectedCustomerToUpdate = customerBean;
    this.router.navigateByUrl('/edit-customer');
  }

  updateCustomer(form: NgForm) {
    this.adminServices.updateCustomer(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('CustomerUpdated Successfuly');
        this.router.navigateByUrl('/customer-home');
      }
      form.reset();
    });
  }

  searchCustomers() {
    this.customerService.searchCustomer().subscribe(response => {
      console.log(response);
      localStorage.setItem('customerDetails', JSON.stringify(response));
      console.log('Customer Details  are in local storage');
      const customerDetails = JSON.parse(localStorage.getItem('customerDetails'));
      this.customers = response.customer;
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}

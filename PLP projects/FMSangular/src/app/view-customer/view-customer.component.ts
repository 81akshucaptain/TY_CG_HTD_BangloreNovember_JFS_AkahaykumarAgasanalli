import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customers: Customers[];
  message: string;

  constructor(
    private adminService: AdminService,
    private router: Router
  ) {
    this.getCustomers();

  }
  getCustomers() {
    this.adminService.viewCustomer().subscribe(response => {
      console.log(response);
      this.customers = response.customer;
    }, err => {
      console.log(err);
    });
  }


  deleteCustomer(customer: Customers) {
    this.adminService.deleteCustomer(customer).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        this.customers.splice(this.customers.indexOf(customer), 1);
        this.message = res.message;
      }
    });
  }

  deleteMessage() {
    this.message = this.message;
  }

  selectedCustomer(customerBean) {
    this.adminService.selectedCustomerToUpdate = customerBean;
    console.log(this.adminService.selectedCustomerToUpdate);
    this.router.navigateByUrl('/update-customer');
  }
  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer-by-scheduler',
  templateUrl: './view-customer-by-scheduler.component.html',
  styleUrls: ['./view-customer-by-scheduler.component.css']
})
export class ViewCustomerBySchedulerComponent implements OnInit {
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
  ngOnInit() {

  }
}

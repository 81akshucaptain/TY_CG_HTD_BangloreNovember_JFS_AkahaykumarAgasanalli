import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customerId1;
  customerName1;
  customerTown1;
  customerPhone1;
  customerEmail1;
  customerPostal1;
  customerPassword1;

  constructor(
    private adminService: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe(data => {
      console.log(data.customerId);
      this.customerId1 = data.customerId;
    });

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.customerName1 = data.name;
      this.customerPhone1 = data.phone;
      this.customerEmail1 = data.email;
      this.customerTown1 = data.town;
      this.customerPostal1 = data.postal;
      this.customerPassword1 = data.password;
    });
  }
  updateCustomer(form: NgForm) {
    this.adminService.updateCustomer(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('CustomerUpdated Successfuly');
        this.router.navigateByUrl('/customer-home');
      }
      form.reset();
    });
  }
  ngOnInit() {
  }

}

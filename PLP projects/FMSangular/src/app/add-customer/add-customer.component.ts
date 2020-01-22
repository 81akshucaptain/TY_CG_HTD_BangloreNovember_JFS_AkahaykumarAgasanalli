import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  error: string;
  message: string;
  constructor(
    private auth: AdminService,
    private router: Router) { }

  addCustomer(form: NgForm) {
    this.auth.addCustomer(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'Customer Added Succesfully') {
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

  ngOnInit() {
  }

}

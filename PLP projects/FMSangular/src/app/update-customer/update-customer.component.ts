import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  constructor(
    private adminService: AdminService,
    private router: Router
  ) { }
  updateCustomer(form: NgForm) {
    this.adminService.updateCustomer(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('CustomerUpdated Successfuly');
        this.router.navigateByUrl('/view-customers');
      }
      form.reset();
    });
  }
  ngOnInit() {
  }

}


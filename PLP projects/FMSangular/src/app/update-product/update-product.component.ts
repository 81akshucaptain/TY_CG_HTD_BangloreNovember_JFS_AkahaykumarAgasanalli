import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {


  constructor(
    private adminService: AdminService,
    private router: Router
  ) { }
  updateLand(form: NgForm) {
    this.adminService.updateProduct(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('ProductUpdated Successfuly');
        this.router.navigateByUrl('/view-products');
      }
      form.reset();
    });
  }
  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productId1;
  productName1;
  productQuantity1;
  productCost1;
  productClass1;

  constructor(
    private adminService: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.productId);
      this.productId1 = data.productId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.productName1 = data.name;
      this.productCost1 = data.cost;
      this.productClass1 = data.productClass;
      this.productQuantity1 = data.quantity;
    });
  }

  updateProduct(form: NgForm) {
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

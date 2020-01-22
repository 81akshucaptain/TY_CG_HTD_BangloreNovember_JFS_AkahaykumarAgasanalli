import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {
  products: Products[];
  message: string;

  constructor(
    private adminService: AdminService,
    private router: Router
  ) {
    this.getProducts();

  }
  getProducts() {
    this.adminService.viewProduct().subscribe(response => {
      console.log(response);
      this.products = response.product;
    }, err => {
      console.log(err);
    });
  }


  deleteproduct(product: Products) {
    this.adminService.deleteProduct(product).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        this.products.splice(this.products.indexOf(product), 1);
        this.message = res.message;
      }
    });
  }

  deleteMessage() {
    this.message = this.message;
  }

  selectedProduct(productBean) {
    this.adminService.selectedProductToUpdate = productBean;
    console.log(this.adminService.selectedProductToUpdate);
    this.router.navigateByUrl('/update-product');
  }
  ngOnInit() {
  }

}

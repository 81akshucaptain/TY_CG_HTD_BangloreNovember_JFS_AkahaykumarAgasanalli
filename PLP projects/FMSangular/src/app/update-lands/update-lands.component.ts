import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-lands',
  templateUrl: './update-lands.component.html',
  styleUrls: ['./update-lands.component.css']
})
export class UpdateLandsComponent implements OnInit {

  constructor(
    private adminService: AdminService,
    private router: Router
  ) { }
  updateLand(form: NgForm) {
    this.adminService.updateLand(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('LandUpdated Successfuly');
        this.router.navigateByUrl('/view-lands');
      }
      form.reset();
    });
  }
  ngOnInit() {
  }

}

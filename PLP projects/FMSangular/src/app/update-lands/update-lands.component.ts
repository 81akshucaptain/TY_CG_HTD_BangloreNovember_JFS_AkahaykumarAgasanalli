import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-lands',
  templateUrl: './update-lands.component.html',
  styleUrls: ['./update-lands.component.css']
})
export class UpdateLandsComponent implements OnInit {
  landId1;
  landLocation1;
  landResources1;
  landSize1;

  constructor(
    private adminService: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe(data => {
      console.log(data.landId);
      this.landId1 = data.landId;
    });

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);

      this.landLocation1 = data.landLocation;
      this.landResources1 = data.landResources;
      this.landSize1 = data.landSize;
    })
  }
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

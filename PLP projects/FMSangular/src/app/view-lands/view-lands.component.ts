import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-lands',
  templateUrl: './view-lands.component.html',
  styleUrls: ['./view-lands.component.css']
})
export class ViewLandsComponent implements OnInit {

  lands: Lands[];
  message: string;

  constructor(
    private adminService: AdminService,
    private router: Router
  ) {
    this.getLands();
  }

  getLands() {
    this.adminService.viewLand().subscribe(response => {
      console.log(response);
      this.lands = response.land;
    }, err => {
      console.log(err);
    });
  }


  deleteLand(land: Lands) {
    this.adminService.deleteLand(land).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        this.lands.splice(this.lands.indexOf(land), 1);
        this.message = res.message;
      }
    });
  }

  deleteMessage() {
    this.message = this.message;
  }

  selectedLand(landbean) {
    this.adminService.selectedLandToUpdate = landbean;
    console.log(this.adminService.selectedLandToUpdate);
    this.router.navigateByUrl('/update-land');
  }
  ngOnInit() {
  }

}

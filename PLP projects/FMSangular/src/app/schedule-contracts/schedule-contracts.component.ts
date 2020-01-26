import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-schedule-contracts',
  templateUrl: './schedule-contracts.component.html',
  styleUrls: ['./schedule-contracts.component.css']
})
export class ScheduleContractsComponent implements OnInit {

  canScheduleTheContract1: boolean;
  canScheduleTheContract2: boolean;


  constructor(private adminServices: AdminService) {
    this.checkDeliverable();
  }
  checkDeliverable() {
    this.canScheduleTheContract1 = this.adminServices.canScheduleTheContract1;
    this.canScheduleTheContract2 = this.adminServices.canScheduleTheContract2;

  }
  ngOnInit() {
  }

}

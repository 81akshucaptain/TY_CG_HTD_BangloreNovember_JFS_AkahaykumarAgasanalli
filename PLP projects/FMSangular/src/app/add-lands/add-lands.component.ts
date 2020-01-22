import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-lands',
  templateUrl: './add-lands.component.html',
  styleUrls: ['./add-lands.component.css']
})
export class AddLandsComponent implements OnInit {
  error: string;
  message: string;
  constructor(
    private auth: AdminService,
    private router: Router) { }

    addLand(form: NgForm) {
    console.log(form.value);

    this.auth.addLand(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'land Added Succesfully') {
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
      form.reset();
    });
  }

  ngOnInit() {
  }

}


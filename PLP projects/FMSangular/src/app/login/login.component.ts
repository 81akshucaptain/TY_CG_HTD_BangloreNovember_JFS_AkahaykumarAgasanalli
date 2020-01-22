import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { log } from 'util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: string;
  constructor(
    private auth: AdminService,
    private router: Router) { }

  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'Logged in') {
        localStorage.setItem('userDetails', JSON.stringify(response));
        console.log('user deatils are in local storage');
        const userDetails = JSON.parse(localStorage.getItem('userDetails'));
        if (userDetails.user[0].user === 'admin') {
          console.log(userDetails.user[0].user);
          this.router.navigateByUrl('/admin-home');
        } else if (userDetails.user[0].user === 'customer') {
          this.router.navigateByUrl('/customer-home');
        } else if (userDetails.user[0].user === 'scheduler') {
          this.router.navigateByUrl('/scheduler-home');
        } else {
          this.router.navigateByUrl('\login');
        }
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

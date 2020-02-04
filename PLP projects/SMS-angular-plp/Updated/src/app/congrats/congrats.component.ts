import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-congrats',
  templateUrl: './congrats.component.html',
  styleUrls: ['./congrats.component.css']
})
export class CongratsComponent implements OnInit {

  constructor(private router: Router) { }
  goToHome() {
    this.router.navigateByUrl('/invester-home');
  }
  ngOnInit() {
  }

}

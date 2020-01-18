import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {
  name = 'akshay';
  imgURL = 'data:image/jpeg;base64,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';
  flag = true;
  // constructor() {
  //   setInterval(() => {
  //     this.flag = !this.flag;
  //   }, 1000);
  // }
  twoWayData;
  clickMe(input) {
    console.log(input.value);
    this.flag = !this.flag;

  }
  printDetails() {
    console.log(this.twoWayData);
  }
  ngOnInit() {
  }

}
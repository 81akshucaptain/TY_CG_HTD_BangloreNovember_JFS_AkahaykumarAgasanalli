import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {
  selectedBike;

bikes = [{
name: 'BMW',
imgURL: 'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg',
details: 'Standard bike BMW'
}, {
  name: 'BJAJA',
  imgURL: 'https://cdn.pixabay.com/photo/2014/07/31/23/37/motorbike-407186__340.jpg',
  details: 'Standard bike BAJAJA'
  },
  {
    name: 'TVS',
    imgURL: 'https://cdn.pixabay.com/photo/2014/12/16/03/37/motor-cycle-569865__340.jpg',
    details: 'Standard bike TVS'
    }, {
      name: 'R1 RAW',
      imgURL: 'https://cdn.pixabay.com/photo/2015/09/08/21/02/superbike-930715__340.jpg',
      details: 'Standard bike R1 RAW'
      }
];
  constructor() { }

  slectBike(bike) {
    this.selectedBike = bike;
  }

  ngOnInit() {
  }

}

import { Component, OnInit, OnChanges, DoCheck, AfterContentInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit, OnChanges, AfterContentInit, OnDestroy  {

dataFromChild;
  student = {
  name: 'shankar',
  age: 20,
  marks: 30
 };

  constructor() { }
// to get data from child component
  getChildData(data) {
    this.dataFromChild = data;
  }

  ngOnInit() {
    console.log('Init Method is Called');
  }
  ngOnChanges() {
    console.log('On changes Data');
  }
  ngAfterContentInit(){
    console.log('After Content Initilaized');
  }
ngOnDestroy(){
  console.log('Destroyedd....');
}
}

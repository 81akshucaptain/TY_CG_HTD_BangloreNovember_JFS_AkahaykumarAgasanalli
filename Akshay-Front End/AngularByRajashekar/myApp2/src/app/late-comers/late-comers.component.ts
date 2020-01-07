import { Component, OnInit } from '@angular/core';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-late-comers',
  templateUrl: './late-comers.component.html',
  styleUrls: ['./late-comers.component.css']
})
export class LateComersComponent implements OnInit {
  flag = true;
  message ;
  person = 'jack';

  lateComers: string[] = [
    'aksha',
    'jacky',
    'anisha',
    'sparrow'
  ];

  constructor() { }

  deleteLateComers(name: string) {
    this.lateComers.splice(this.lateComers.indexOf(name), 1);
    this.message = `${name} is deleted`;
    setTimeout(() => {
      this.message = null;
    }, 1000);
  }
  ngOnInit() {
  }

}

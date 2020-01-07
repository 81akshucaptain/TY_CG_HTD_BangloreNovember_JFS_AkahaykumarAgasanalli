import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MownaComponent } from './mowna.component';

describe('MownaComponent', () => {
  let component: MownaComponent;
  let fixture: ComponentFixture<MownaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MownaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MownaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

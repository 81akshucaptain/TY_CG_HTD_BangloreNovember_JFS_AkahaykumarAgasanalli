import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLandsComponent } from './add-lands.component';

describe('AddLandsComponent', () => {
  let component: AddLandsComponent;
  let fixture: ComponentFixture<AddLandsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLandsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLandsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

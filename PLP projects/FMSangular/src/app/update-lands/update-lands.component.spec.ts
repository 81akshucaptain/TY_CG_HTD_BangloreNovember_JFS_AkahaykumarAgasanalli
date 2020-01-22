import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateLandsComponent } from './update-lands.component';

describe('UpdateLandsComponent', () => {
  let component: UpdateLandsComponent;
  let fixture: ComponentFixture<UpdateLandsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateLandsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateLandsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

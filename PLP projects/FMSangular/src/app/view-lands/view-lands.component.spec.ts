import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewLandsComponent } from './view-lands.component';

describe('ViewLandsComponent', () => {
  let component: ViewLandsComponent;
  let fixture: ComponentFixture<ViewLandsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewLandsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewLandsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

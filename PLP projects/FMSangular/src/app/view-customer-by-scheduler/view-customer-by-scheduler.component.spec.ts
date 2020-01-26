import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCustomerBySchedulerComponent } from './view-customer-by-scheduler.component';

describe('ViewCustomerBySchedulerComponent', () => {
  let component: ViewCustomerBySchedulerComponent;
  let fixture: ComponentFixture<ViewCustomerBySchedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCustomerBySchedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCustomerBySchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

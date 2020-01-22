import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewContractsBySchedulerComponent } from './view-contracts-by-scheduler.component';

describe('ViewContractsBySchedulerComponent', () => {
  let component: ViewContractsBySchedulerComponent;
  let fixture: ComponentFixture<ViewContractsBySchedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewContractsBySchedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewContractsBySchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

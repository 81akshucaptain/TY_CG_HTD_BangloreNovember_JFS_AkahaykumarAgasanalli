import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleContractsComponent } from './schedule-contracts.component';

describe('ScheduleContractsComponent', () => {
  let component: ScheduleContractsComponent;
  let fixture: ComponentFixture<ScheduleContractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleContractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

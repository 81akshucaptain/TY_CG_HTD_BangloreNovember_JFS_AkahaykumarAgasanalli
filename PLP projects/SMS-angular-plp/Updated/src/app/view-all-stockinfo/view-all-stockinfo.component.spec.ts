import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllStockinfoComponent } from './view-all-stockinfo.component';

describe('ViewAllStockinfoComponent', () => {
  let component: ViewAllStockinfoComponent;
  let fixture: ComponentFixture<ViewAllStockinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllStockinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllStockinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

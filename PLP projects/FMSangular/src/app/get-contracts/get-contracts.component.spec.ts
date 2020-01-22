import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetContractsComponent } from './get-contracts.component';

describe('GetContractsComponent', () => {
  let component: GetContractsComponent;
  let fixture: ComponentFixture<GetContractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetContractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

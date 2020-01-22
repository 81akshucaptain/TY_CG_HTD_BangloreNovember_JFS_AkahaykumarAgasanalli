import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateContractsComponent } from './update-contracts.component';

describe('UpdateContractsComponent', () => {
  let component: UpdateContractsComponent;
  let fixture: ComponentFixture<UpdateContractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateContractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

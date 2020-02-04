import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateInvesterComponent } from './update-invester.component';

describe('UpdateInvesterComponent', () => {
  let component: UpdateInvesterComponent;
  let fixture: ComponentFixture<UpdateInvesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateInvesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateInvesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

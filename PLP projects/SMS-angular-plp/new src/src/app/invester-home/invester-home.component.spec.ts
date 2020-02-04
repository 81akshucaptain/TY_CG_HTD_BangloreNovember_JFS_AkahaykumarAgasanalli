import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvesterHomeComponent } from './invester-home.component';

describe('InvesterHomeComponent', () => {
  let component: InvesterHomeComponent;
  let fixture: ComponentFixture<InvesterHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvesterHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvesterHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

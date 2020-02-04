import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginInvesterComponent } from './login-invester.component';

describe('LoginInvesterComponent', () => {
  let component: LoginInvesterComponent;
  let fixture: ComponentFixture<LoginInvesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginInvesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginInvesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

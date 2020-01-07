import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AkshayComponent } from './akshay.component';

describe('AkshayComponent', () => {
  let component: AkshayComponent;
  let fixture: ComponentFixture<AkshayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AkshayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AkshayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

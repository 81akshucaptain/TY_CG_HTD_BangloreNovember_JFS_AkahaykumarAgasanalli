import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MallikComponent } from './mallik.component';

describe('MallikComponent', () => {
  let component: MallikComponent;
  let fixture: ComponentFixture<MallikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MallikComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MallikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

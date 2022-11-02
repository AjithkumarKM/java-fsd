import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustActionComponent } from './cust-action.component';

describe('CustActionComponent', () => {
  let component: CustActionComponent;
  let fixture: ComponentFixture<CustActionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustActionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

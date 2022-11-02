import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DuplicateAadharComponent } from './duplicate-aadhar.component';

describe('DuplicateAadharComponent', () => {
  let component: DuplicateAadharComponent;
  let fixture: ComponentFixture<DuplicateAadharComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DuplicateAadharComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DuplicateAadharComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

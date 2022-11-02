import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IsssueAadharComponent } from './isssue-aadhar.component';

describe('IsssueAadharComponent', () => {
  let component: IsssueAadharComponent;
  let fixture: ComponentFixture<IsssueAadharComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IsssueAadharComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IsssueAadharComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContestsDetailComponent } from './contests-detail.component';

describe('ContestsDetailComponent', () => {
  let component: ContestsDetailComponent;
  let fixture: ComponentFixture<ContestsDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContestsDetailComponent]
    });
    fixture = TestBed.createComponent(ContestsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

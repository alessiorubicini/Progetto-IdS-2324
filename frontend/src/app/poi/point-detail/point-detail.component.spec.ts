import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PointDetailComponent } from './point-detail.component';

describe('PointDetailComponent', () => {
  let component: PointDetailComponent;
  let fixture: ComponentFixture<PointDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PointDetailComponent]
    });
    fixture = TestBed.createComponent(PointDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

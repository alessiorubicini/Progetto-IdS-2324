import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateContestComponent } from './create-contest.component';

describe('CreateContestComponent', () => {
  let component: CreateContestComponent;
  let fixture: ComponentFixture<CreateContestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateContestComponent]
    });
    fixture = TestBed.createComponent(CreateContestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

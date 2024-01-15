import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentListComponent } from './content-list.component';

describe('ContentListComponent', () => {
  let component: ContentListComponent;
  let fixture: ComponentFixture<ContentListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContentListComponent]
    });
    fixture = TestBed.createComponent(ContentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

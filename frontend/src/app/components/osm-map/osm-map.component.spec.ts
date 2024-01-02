import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OsmMapComponent } from './osm-map.component';

describe('OsmMapComponent', () => {
  let component: OsmMapComponent;
  let fixture: ComponentFixture<OsmMapComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OsmMapComponent]
    });
    fixture = TestBed.createComponent(OsmMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

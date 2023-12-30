import { TestBed } from '@angular/core/testing';

import { MockdataService } from './mockdata.service';

describe('MockdataService', () => {
  let service: MockdataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MockdataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

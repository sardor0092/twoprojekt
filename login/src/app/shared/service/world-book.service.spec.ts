import { TestBed } from '@angular/core/testing';

import { WorldBookService } from './world-book.service';

describe('WorldBookService', () => {
  let service: WorldBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorldBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { DarsBooksService } from './dars-books.service';

describe('DarsBooksService', () => {
  let service: DarsBooksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DarsBooksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

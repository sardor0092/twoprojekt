import { TestBed } from '@angular/core/testing';

import { CalibBooksService } from './calib-books.service';

describe('CalibBooksService', () => {
  let service: CalibBooksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalibBooksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

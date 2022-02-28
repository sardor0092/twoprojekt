import { TestBed } from '@angular/core/testing';

import { BadiiyBooksService } from './badiiy-books.service';

describe('BadiiyBooksService', () => {
  let service: BadiiyBooksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BadiiyBooksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { HistoryBooksService } from './history-books.service';

describe('HistoryBooksService', () => {
  let service: HistoryBooksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HistoryBooksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

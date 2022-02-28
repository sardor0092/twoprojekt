import { TestBed } from '@angular/core/testing';

import { BooknewsService } from './booknews.service';

describe('BooknewsService', () => {
  let service: BooknewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BooknewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

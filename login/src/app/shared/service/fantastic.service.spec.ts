import { TestBed } from '@angular/core/testing';

import { FantasticService } from './fantastic.service';

describe('FantasticService', () => {
  let service: FantasticService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FantasticService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

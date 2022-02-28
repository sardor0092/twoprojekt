import { TestBed } from '@angular/core/testing';

import { TizimgaService } from './tizimga.service';

describe('TizimgaService', () => {
  let service: TizimgaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TizimgaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

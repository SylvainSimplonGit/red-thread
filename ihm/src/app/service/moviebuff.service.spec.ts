import { TestBed } from '@angular/core/testing';

import { MovieBuffService } from './movieBuff.service';

describe('MovieBuffService', () => {
  let service: MovieBuffService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieBuffService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

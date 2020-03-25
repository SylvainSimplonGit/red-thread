import { TestBed } from '@angular/core/testing';

import { AddAMovieService } from './add-amovie.service';

describe('AddAMovieService', () => {
  let service: AddAMovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddAMovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

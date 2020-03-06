import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieSuggestionComponent } from './movie-suggestion.component';

describe('MovieSuggestionComponent', () => {
  let component: MovieSuggestionComponent;
  let fixture: ComponentFixture<MovieSuggestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieSuggestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieSuggestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

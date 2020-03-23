import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreSuggestionComponent } from './genre-suggestion.component';

describe('GenreSuggestionComponent', () => {
  let component: GenreSuggestionComponent;
  let fixture: ComponentFixture<GenreSuggestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenreSuggestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenreSuggestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

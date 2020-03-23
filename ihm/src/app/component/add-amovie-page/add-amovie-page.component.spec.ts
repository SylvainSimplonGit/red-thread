import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAMoviePageComponent } from './add-amovie-page.component';

describe('AddAMoviePageComponent', () => {
  let component: AddAMoviePageComponent;
  let fixture: ComponentFixture<AddAMoviePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAMoviePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAMoviePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

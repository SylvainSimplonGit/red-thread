import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectorSheetComponent } from './director-sheet.component';

describe('DirectorSheetComponent', () => {
  let component: DirectorSheetComponent;
  let fixture: ComponentFixture<DirectorSheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectorSheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectorSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpinionListComponent } from './opinion-list.component';

describe('OpinionListComponent', () => {
  let component: OpinionListComponent;
  let fixture: ComponentFixture<OpinionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpinionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpinionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpinionMineComponent } from './opinion-mine.component';

describe('OpinionMineComponent', () => {
  let component: OpinionMineComponent;
  let fixture: ComponentFixture<OpinionMineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpinionMineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpinionMineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

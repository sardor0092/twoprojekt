import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BadiiyComponent } from './badiiy.component';

describe('BadiiyComponent', () => {
  let component: BadiiyComponent;
  let fixture: ComponentFixture<BadiiyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BadiiyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BadiiyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksnewComponent } from './booksnew.component';

describe('BooksnewComponent', () => {
  let component: BooksnewComponent;
  let fixture: ComponentFixture<BooksnewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksnewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BooksnewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

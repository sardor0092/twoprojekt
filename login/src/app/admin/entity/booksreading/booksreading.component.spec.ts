import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksreadingComponent } from './booksreading.component';

describe('BooksreadingComponent', () => {
  let component: BooksreadingComponent;
  let fixture: ComponentFixture<BooksreadingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksreadingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BooksreadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

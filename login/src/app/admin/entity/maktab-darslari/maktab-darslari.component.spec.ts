import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaktabDarslariComponent } from './maktab-darslari.component';

describe('MaktabDarslariComponent', () => {
  let component: MaktabDarslariComponent;
  let fixture: ComponentFixture<MaktabDarslariComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaktabDarslariComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaktabDarslariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FantastikComponent } from './fantastik.component';

describe('FantastikComponent', () => {
  let component: FantastikComponent;
  let fixture: ComponentFixture<FantastikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FantastikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FantastikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarixiyComponent } from './tarixiy.component';

describe('TarixiyComponent', () => {
  let component: TarixiyComponent;
  let fixture: ComponentFixture<TarixiyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarixiyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TarixiyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

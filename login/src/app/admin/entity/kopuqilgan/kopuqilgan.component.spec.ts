import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KopuqilganComponent } from './kopuqilgan.component';

describe('KopuqilganComponent', () => {
  let component: KopuqilganComponent;
  let fixture: ComponentFixture<KopuqilganComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KopuqilganComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KopuqilganComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

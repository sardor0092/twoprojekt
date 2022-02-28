import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JahonAdabiyotiComponent } from './jahon-adabiyoti.component';

describe('JahonAdabiyotiComponent', () => {
  let component: JahonAdabiyotiComponent;
  let fixture: ComponentFixture<JahonAdabiyotiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JahonAdabiyotiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JahonAdabiyotiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

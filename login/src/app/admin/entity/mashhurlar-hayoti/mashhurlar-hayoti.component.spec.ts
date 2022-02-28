import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MashhurlarHayotiComponent } from './mashhurlar-hayoti.component';

describe('MashhurlarHayotiComponent', () => {
  let component: MashhurlarHayotiComponent;
  let fixture: ComponentFixture<MashhurlarHayotiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MashhurlarHayotiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MashhurlarHayotiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

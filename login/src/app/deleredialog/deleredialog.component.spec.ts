import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleredialogComponent } from './deleredialog.component';

describe('DeleredialogComponent', () => {
  let component: DeleredialogComponent;
  let fixture: ComponentFixture<DeleredialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleredialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleredialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

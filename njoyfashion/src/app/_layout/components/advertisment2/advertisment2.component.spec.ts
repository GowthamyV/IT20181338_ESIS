import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Advertisment2Component } from './advertisment2.component';

describe('Advertisment2Component', () => {
  let component: Advertisment2Component;
  let fixture: ComponentFixture<Advertisment2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [Advertisment2Component]
    });
    fixture = TestBed.createComponent(Advertisment2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

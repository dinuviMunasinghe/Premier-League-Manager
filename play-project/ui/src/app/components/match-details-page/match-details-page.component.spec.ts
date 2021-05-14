import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchDetailsPageComponent } from './match-details-page.component';

describe('MatchDetailsPageComponent', () => {
  let component: MatchDetailsPageComponent;
  let fixture: ComponentFixture<MatchDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchDetailsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

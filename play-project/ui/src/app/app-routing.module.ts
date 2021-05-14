import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomePageComponent } from './components/home-page/home-page.component';
import { ClubDetailsPageComponent } from './components/club-details-page/club-details-page.component';
import { MatchDetailsPageComponent } from './components/match-details-page/match-details-page.component';
import { RandomMatchComponent } from './components/random-match/random-match.component';

const routes: Routes = [
  { path: 'home-page', component: HomePageComponent },
  { path: 'club-details-page', component: ClubDetailsPageComponent },
  { path: 'match-details-page', component: MatchDetailsPageComponent },
  { path: 'random-match', component: RandomMatchComponent },
  { path: '', redirectTo: '/home-page', pathMatch: 'full' },
  { path: '**', redirectTo: '/home-page', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }

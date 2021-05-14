import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppService} from "./app.service";
// import { MatTableModule } from '@angular/material/table';

import { HomePageComponent } from './components/home-page/home-page.component';
import { ClubDetailsPageComponent } from './components/club-details-page/club-details-page.component';
import { MatchDetailsPageComponent } from './components/match-details-page/match-details-page.component';
import {HttpClientModule} from "@angular/common/http";
import { RandomMatchComponent } from './components/random-match/random-match.component';


@NgModule({
  declarations: [
    AppComponent,
    ClubDetailsPageComponent,
    MatchDetailsPageComponent,
    HomePageComponent,
    RandomMatchComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})

export class AppModule { }



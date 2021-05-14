import { Component, OnInit } from '@angular/core';
import { AppService} from "../../app.service";

@Component({
  selector: 'app-club-details-page',
  templateUrl: './club-details-page.component.html',
  styleUrls: ['./club-details-page.component.css']
})

export class ClubDetailsPageComponent implements OnInit {
  ItemsArray : any;

  constructor(private appService : AppService) { }

  ngOnInit() {}

  sortByPoints() {
    this.appService.getClubsByPoints().subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }

  sortByGoalsScored() {
    this.appService.getClubsByScored().subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }

  sortByWins() {
    this.appService.getClubsByWins().subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }
}

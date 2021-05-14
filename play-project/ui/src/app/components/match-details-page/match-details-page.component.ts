import { Component, OnInit } from '@angular/core';
import { AppService } from "../../app.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-match-details-page',
  templateUrl: './match-details-page.component.html',
  styleUrls: ['./match-details-page.component.css']
})

export class MatchDetailsPageComponent implements OnInit {
  ItemsArray : any;
  private matchesApi = "/api/getMatches";

  constructor(private appService : AppService, private httpClient: HttpClient) { }

  ngOnInit(){}

  sortMatches(){
    this.appService.getSortedMatches().subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }

  dateEntered(val: string){
    this.appService.getSearchMatchResults(val).subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }

}

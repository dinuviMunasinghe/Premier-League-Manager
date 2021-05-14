import { Component, OnInit } from '@angular/core';
import { AppService } from "../../app.service";

@Component({
  selector: 'app-random-match',
  templateUrl: './random-match.component.html',
  styleUrls: ['./random-match.component.css']
})
export class RandomMatchComponent implements OnInit {
  headersArray:string[] = ["Team One Name - ", "Team One Score - ", "Team Two Name - ", "Team Two Score - ", "Date - "];
  ItemsArray : any;

  constructor(private appService:AppService) { }

  ngOnInit(){}

  playMatch(){
    this.appService.getRandomMatch().subscribe((res: any[])=>{
      this.ItemsArray= res;
    })
  }

}

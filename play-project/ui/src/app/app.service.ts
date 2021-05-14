import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AppService {
  private pointsApi = "/api/getClubSortedByPoints";
  private goalsScoredApi = "/api/getClubSortedByGoalsScored";
  private winsApi = "/api/getClubSortedByWins";
  private randomMatchApi = "/api/getRandomMatch";
  private sortMatchesApi = "/api/getSortedMatches";
  private searchMatchApi = "/api/getSearchMatch";

  constructor(private httpClient: HttpClient) {}

  getClubsByPoints(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.pointsApi);
  }

  getClubsByScored(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.goalsScoredApi);
  }

  getClubsByWins(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.winsApi);
  }

  getRandomMatch(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.randomMatchApi);
  }

  getSortedMatches(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.sortMatchesApi);
  }

  public getSearchMatchResults(searchDate: string): Observable<any[]> {
    const params = new HttpParams().set("searchDate", searchDate);
    return this.httpClient.get<any[]>(this.searchMatchApi, {params});
  }
}



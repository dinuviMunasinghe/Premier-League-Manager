package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.FootballClub;
import entities.Match;
import play.libs.Json;
import play.mvc.*;
import services.LeagueManager;
import services.PremierLeagueManager;
import java.util.List;

public class HomeController extends Controller{
    private static final LeagueManager leagueManager = PremierLeagueManager.getInstance();

    public Result getClubSortedByPoints(){
        JsonNode node;
        try{
            List<FootballClub> footballClubs = (((PremierLeagueManager)leagueManager).clubsSortedAccordingToPoints());
            System.out.println(footballClubs);
            node = Json.toJson(footballClubs);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }

    public Result getClubSortedByGoalsScored(){
        JsonNode node;
        try{
            List<FootballClub> footballClubs = (((PremierLeagueManager)leagueManager).clubsSortedAccordingToGoalsScored());
            System.out.println(footballClubs);
            node = Json.toJson(footballClubs);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }

    public Result getClubSortedByWins(){
        JsonNode node;
        try{
            List<FootballClub> footballClubs = (((PremierLeagueManager)leagueManager).clubsSortedAccordingToWins());
            System.out.println(footballClubs);
            node = Json.toJson(footballClubs);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }

    public Result getSortedMatches(){
        JsonNode node;
        try{
            List<Match> matches = (((PremierLeagueManager)leagueManager).sortingMatches());
            System.out.println(matches);
            node = Json.toJson(matches);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }

    public Result getRandomMatch(){
        JsonNode node;
        try{
            List<String> match = (((PremierLeagueManager)leagueManager).generatingARandomMatch());
            System.out.println(match);
            node = Json.toJson(match);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }

    public Result getSearchMatch(String searchDate){
        JsonNode node;
        try{
            List<Match> match = (((PremierLeagueManager)leagueManager).searchingAMatch(searchDate));
            System.out.println(match);
            node = Json.toJson(match);
            System.out.println(node);
            return created(node);
        }catch (Exception e){
            return null;
        }
    }
}

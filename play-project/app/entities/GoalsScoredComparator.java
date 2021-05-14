package entities;

import java.util.Comparator;

public class GoalsScoredComparator implements Comparator<FootballClub>{
    @Override
    public int compare(FootballClub footballClubOne,FootballClub footballClubTwo){
        if(footballClubOne.getNoOfGoalsScored() == footballClubTwo.getNoOfGoalsScored())
            return 0;
        else if(footballClubOne.getNoOfGoalsScored() < footballClubTwo.getNoOfGoalsScored())
            return 1;
        else
            return -1;
    }
}
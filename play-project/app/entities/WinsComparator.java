package entities;

import java.util.Comparator;

public class WinsComparator implements Comparator<FootballClub>{
    @Override
    public int compare(FootballClub footballClubOne,FootballClub footballClubTwo){
        if(footballClubOne.getNoOfWins() == footballClubTwo.getNoOfWins())
            return 0;
        else if(footballClubOne.getNoOfWins() < footballClubTwo.getNoOfWins())
            return 1;
        else
            return -1;
    }
}

package entities;

import java.util.Comparator;

public class PointsComparator implements Comparator<FootballClub>{
    @Override
    public int compare(FootballClub footballClubOne,FootballClub footballClubTwo){
        if(footballClubOne.getNoOfPoints() == footballClubTwo.getNoOfPoints())
            return 0;
        else if(footballClubOne.getNoOfPoints() < footballClubTwo.getNoOfPoints())
            return 1;
        else
            return -1;
    }
}

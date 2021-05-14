package entities;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable{
    private int noOfWins;
    private int noOfDraws;
    private int noOfDefeats;
    private int noOfGoalsScored;
    private int noOfGoalsReceived;
    private int noOfPoints;
    private int noOfMatchesPlayed;

    //constructor without parameters
    public FootballClub(){}

    //parameterised constructor
    public FootballClub(String nameOfClub, String locationOfClub){
        super(nameOfClub, locationOfClub);
    }

    //parameterised constructor
    public FootballClub(int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoalsScored, int noOfGoalsReceived, int noOfPoints, int noOfMatchesPlayed){
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfPoints = noOfPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    //parameterised constructor
    public FootballClub(int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoalsScored, int noOfGoalsReceived, int noOfPoints, int noOfMatchesPlayed, String nameOfClub, String locationOfClub){
        super(nameOfClub, locationOfClub);
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfPoints = noOfPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public int getNoOfWins(){
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins){
        if(noOfWins >= 0){
            this.noOfWins = this.noOfWins + noOfWins;
        }
    }

    public int getNoOfDraws(){
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws){
        if(noOfDraws >= 0){
            this.noOfDraws = this.noOfDraws + noOfDraws;
        }
    }

    public int getNoOfDefeats(){
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats){
        if(noOfDefeats >= 0){
            this.noOfDefeats = this.noOfDefeats + noOfDefeats;
        }
    }

    public int getNoOfGoalsScored(){
        return noOfGoalsScored;
    }

    public void setNoOfGoalsScored(int noOfGoalsScored){
        if(noOfGoalsScored >= 0){
            this.noOfGoalsScored = this.noOfGoalsScored + noOfGoalsScored;
        }
    }

    public int getNoOfGoalsReceived(){
        return noOfGoalsReceived;
    }

    public void setNoOfGoalsReceived(int noOfGoalsReceived){
        if(noOfGoalsReceived >= 0){
            this.noOfGoalsReceived = this.noOfGoalsReceived + noOfGoalsReceived;
        }
    }

    public int getNoOfPoints(){
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints){
        if(noOfPoints >= 0){
            this.noOfPoints = this.noOfPoints + noOfPoints;
        }
    }

    public int getNoOfMatchesPlayed(){
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed){
        if(noOfMatchesPlayed >= 0){
            this.noOfMatchesPlayed = this.noOfMatchesPlayed + noOfMatchesPlayed;
        }
    }

    @Override
    public int compareTo(FootballClub club){
        if(noOfPoints == club.noOfPoints){
            int goalDifference = noOfGoalsScored - noOfGoalsReceived;
            if(goalDifference == (club.getNoOfGoalsScored() - club.getNoOfGoalsReceived())){
                return 0;
            }
            else if(noOfPoints < club.noOfPoints)
                return 1;
            else
                return -1;
        }
        else if(noOfPoints < club.noOfPoints)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "Number of Wins - "+ noOfWins +
                "Number of Draws - "+ noOfDraws +
                "Number of Defeats - "+ noOfDefeats +
                "Number of Goals Scored - "+ noOfGoalsScored +
                "Number of Goals getNoOfGoalsReceived - "+ noOfGoalsReceived +
                "Number of Points - "+ noOfPoints +
                "Number of Matches Played - "+ noOfMatchesPlayed );
    }
}


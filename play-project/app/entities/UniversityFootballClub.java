package entities;

public class UniversityFootballClub extends FootballClub{
    private String universityName;

    //a constructor without parameters
    public UniversityFootballClub(){}

    //parameterised constructor
    public UniversityFootballClub(String universityName){
        this.universityName = universityName;
    }

    public String getUniversityName(){
        return universityName;
    }

    public void setUniversityName(String universityName){
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return (super.toString() + "University name  - " + universityName);
    }
}

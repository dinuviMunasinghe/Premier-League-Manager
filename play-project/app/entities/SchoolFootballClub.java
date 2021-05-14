package entities;

public class SchoolFootballClub extends FootballClub{
    private String schoolName;

    //a constructor without parameters
    public SchoolFootballClub(){}

    //parameterised constructor
    public SchoolFootballClub(String schoolName){
        this.schoolName = schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return (super.toString() + "School name  - " + schoolName);
    }
}

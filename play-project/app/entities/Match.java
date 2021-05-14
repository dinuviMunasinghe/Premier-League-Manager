package entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Match implements Serializable {
    private String teamOneName;
    private int teamOneScore;
    private String teamTwoName;
    private int teamTwoScore;
    private String date;

    public Match(){}

    public Match(String teamOneName, int teamOneScore, String teamTwoName, int teamTwoScore, String date){
        this.teamOneName = teamOneName;
        this.teamOneScore = teamOneScore;
        this.teamTwoName = teamTwoName;
        this.teamTwoScore = teamTwoScore;
        this.date = date;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //validates the date passed to the method
    public boolean dateValidation(String date) {
        boolean isValid;
        if (date.trim().equals("")) {
            isValid = false;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(date);
                isValid = true;
            } catch (ParseException e) {
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public String toString() {
        return "Match - " + "teamOneName = " + teamOneName + ", teamOneScore = " + teamOneScore + ", teamTwoName = " + teamTwoName + ", teamTwoScore = " + teamTwoScore + ", date = " + date;
    }
}


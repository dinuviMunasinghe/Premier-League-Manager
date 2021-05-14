package services;

import java.io.IOException;

public interface  LeagueManager{
    void addTeam() throws IOException, ClassNotFoundException;
    void deleteTeam();
    void displayingStatisticsForAClub() throws IOException, ClassNotFoundException;
    void displayingPremierLeagueTable() throws IOException, ClassNotFoundException;
    void addMatch() throws IOException;
    void savingDataToFile(String clubFile, String matchFile)throws IOException;
    void loadingDataFromFile(String clubFile, String matchFile)throws IOException, ClassNotFoundException;
}

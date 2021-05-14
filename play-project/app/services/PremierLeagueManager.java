package services;

import entities.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PremierLeagueManager implements LeagueManager{
    //creating an instance
    private static PremierLeagueManager instance;

    final static public int NO_OF_CLUBS = 20;
    private static ArrayList<FootballClub> footballClubArrayList;
    private static ArrayList<Match> matchArrayList;

    public static PremierLeagueManager getInstance(){
        instance = new PremierLeagueManager();
        return instance;
    }

    public PremierLeagueManager(){
        footballClubArrayList = new ArrayList<>();
        matchArrayList = new ArrayList<>();
    }

    public void addTeam() throws IOException, ClassNotFoundException {
        Scanner optionScanner = new Scanner(System.in);
        try{
            if(footballClubArrayList.size() == NO_OF_CLUBS){          //checks if there are 20 clubs added already
                System.out.print("Twenty clubs have been already added to the Premier League!!!");
            }else{
                System.out.print("Enter the name of the club: ");             //taking the user input for the name of the club
                String nameOfClub = optionScanner.nextLine();
                if((!validatingString(nameOfClub))){    //checks if the club name entered is valid
                    System.out.println("The club name you entered is not valid");
                }else{
                    //checking if the club entered is already present in the Premier League
                    if(checkTeam(nameOfClub)){
                        System.out.print("The club name you entered is already present in the Premier League");
                    }else{
                        System.out.print("Enter the location of the club: ");       //taking the user input for the location of the club
                        String locationOfClub = optionScanner.nextLine();
                        if(validatingString(locationOfClub)){            //checks if the club location entered is valid
                            //creating an object of FootballClub withe provided name and location
                            FootballClub footballClubObj = new FootballClub(nameOfClub, locationOfClub);
                            footballClubArrayList.add(footballClubObj);    //adding the object to the arrayList which has all the list of all clubs in the premier league
                            System.out.println("A Club was added to the Premier League\n     Name Of Club - " + nameOfClub + "\n     Location Of Club - " + locationOfClub);
                        }else{
                            System.out.println("The location you entered is not valid");
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Wrong data entered......");
        }
        System.out.println();
    }

    public void deleteTeam(){
        Scanner optionScanner = new Scanner(System.in);
        System.out.print("Enter the name of the football club to see its statistics: ");  //user enters the club name to be deleted
        String enteredNameOfClub = optionScanner.nextLine();
        char found = 'n';
        //loops the arrayList that has the details about the club details and deletes the particular record
        for(int i = 0; i < footballClubArrayList.size(); i++) {
            //checks if the index of the arraylist is null
            if(footballClubArrayList.get(i) != null && footballClubArrayList.get(i).getNameOfClub() != null){
                if(footballClubArrayList.get(i).getNameOfClub().equals(enteredNameOfClub)){
                    footballClubArrayList.remove(i);
                    //prints the details of the club that was deleted
                    System.out.println("A Club was removed from the Premier League\n     Name Of Club - " + footballClubArrayList.get(i).getNameOfClub() +
                            "\n     Location Of Club - " + footballClubArrayList.get(i).getLocationOfClub());
//                    System.out.print("The team " + enteredNameOfClub + " was deleted from the Premier League ");
                    System.out.println();
                    found = 'y';
                    break;
                }
            } else {System.out.println("Its an null value");}
        }
        //notify the user if he has entered a club that is not added to the Premier League
        if(found == 'n'){
            System.out.println("You have entered a club name that is not added to the Premier League.");
        }
    }

    public void displayingStatisticsForAClub() throws IOException, ClassNotFoundException {
        Scanner optionScanner = new Scanner(System.in);
        System.out.print("Enter the name of the football club to see its statistics: "); //user enters the name of the club
        String enteredNameOfClub = optionScanner.nextLine();
        char found = 'n';
        //loops the arrayList that has the details about the club details and shows the details of the club which the user wants
        for(FootballClub arrayListRecord : footballClubArrayList){
            if(arrayListRecord != null && arrayListRecord.getNameOfClub() != null){
                if(arrayListRecord.getNameOfClub().equals(enteredNameOfClub)){
                    //prints the statistics of the club
                    System.out.println("The statistics of the club " + enteredNameOfClub + " is: ");
                    System.out.println("        Number of wins - " + arrayListRecord.getNoOfWins() +
                            "\n        Number of draws - " + arrayListRecord.getNoOfDraws() +
                            "\n        Number of defeats - " + arrayListRecord.getNoOfDefeats() +
                            "\n        Number of goals scored - " + arrayListRecord.getNoOfGoalsScored() +
                            "\n        Number of goals received - " + arrayListRecord.getNoOfGoalsReceived() +
                            "\n        Number of points - " + arrayListRecord.getNoOfPoints() +
                            "\n        Number of matches played  - " + arrayListRecord.getNoOfMatchesPlayed());
                    found = 'y';
                    break;
                }
            }else{
                System.out.println("Its an null value");
            }
        }
        //notify the user if he has entered a club that is not added to the Premier League
        if(found == 'n'){
            System.out.println("You have entered a club name that is not registered in the premier league.");
        }
    }

    public void displayingPremierLeagueTable(){
        if(footballClubArrayList.size() == 0){
            System.out.println("No Clubs added to the Premier League");
        }else{
            ArrayList<FootballClub> tempArrayLIst = new ArrayList<>();    //creates a temporary arrayList
            tempArrayLIst.addAll(footballClubArrayList);            //add all the details of the "footballClubArrayList" to the "tempArrayLIst"
            Collections.sort(tempArrayLIst);       //sorts the "tempArrayLIst"

            //printing the table headings
            System.out.println("Name" + "               " +
                    "Won"+ "               " +
                    "Drawn"+ "               " +
                    "Lost"+ "               " +
                    "Goals Scored"+ "               " +
                    "Goals Received"+ "               " +
                    "Points"+ "               " +
                    "Played"+ "               " );

            //printing the club details
            for (FootballClub footballClub : tempArrayLIst) {
                System.out.println(footballClub.getNameOfClub() + "             " +
                        footballClub.getNoOfWins() + "                   " +
                        footballClub.getNoOfDraws() + "                    " +
                        footballClub.getNoOfDefeats() + "                       " +
                        footballClub.getNoOfGoalsScored() + "                          " +
                        footballClub.getNoOfGoalsReceived() + "                         " +
                        footballClub.getNoOfPoints() + "                    " +
                        footballClub.getNoOfMatchesPlayed());
            }
        }

    }

    public void addMatch() throws NumberFormatException, NullPointerException, IOException {
        Scanner optionScanner = new Scanner(System.in);
        Match matchObj = new Match();
        String teamOneName, teamTwoName, date = "";
        int teamOneScore = 0, teamTwoScore = 0;
        boolean loop = true;
        System.out.print("Enter the name of the Team One: ");      //taking the user input for name of the Team One who played the match
        teamOneName = optionScanner.nextLine();
        if(checkTeam(teamOneName)){
            System.out.print("Enter the score of the Team One: ");      //taking the user input for score of the Team One who played the match
            teamOneScore = optionScanner. nextInt();
            System.out.print("Enter the name of the Team Two: ");      //taking the user input for name of the Team Two who played the match
            teamTwoName = optionScanner.next();
            if(checkTeam(teamTwoName)){
                System.out.print("Enter the score of the Team One : ");      //taking the user input for score of the Team One who played the match
                teamTwoScore = optionScanner.nextInt();
                while(loop){
                    System.out.print("Enter the date of the match(dd/mm/yyyy): ");      //taking the user input for name of the Team One who played the match
                    date = optionScanner.next();
                    if(matchObj.dateValidation(date)){
                        checkingTheScenarioOfMatch(teamOneName, teamTwoName, teamOneScore, teamTwoScore, date);
                        loop = false;
                    }else{
                        System.out.println("The date entered was invalid. Try again");
                    }
                }
            }else{
                System.out.print("The second club entered is not in the Premier League.");
            }
        }else{
            System.out.print("The first club entered is not in the Premier League.");
        }
        System.out.println();
    }

    public void checkingTheScenarioOfMatch(String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore, String date) throws IOException {
        if(teamOneScore > teamTwoScore){
            //updating the statistics of Team One, if it has won the match
            updatingStatistics(teamOneName, 1, 0, 0, teamOneScore, teamTwoScore, 3, 1);
            //updating the statistics of Team Two, if it has lost the match
            updatingStatistics(teamTwoName, 0, 0, 1, teamTwoScore, teamOneScore, 0, 1);
        }else if(teamTwoScore > teamOneScore){
            //updating the statistics of Team One, if it has lost the match
            updatingStatistics(teamOneName, 0, 0, 1, teamOneScore, teamTwoScore, 0, 1);
            //updating the statistics of Team Two, if it has won the match
            updatingStatistics(teamTwoName, 1, 0, 0, teamTwoScore, teamOneScore, 3, 1);
        } else {
            //updating the statistics of Team One, if both the teams are draw
            updatingStatistics(teamOneName, 0, 1, 0, teamOneScore, teamTwoScore, 1, 1);
            //updating the statistics of Team Two, if both the teams are draw
            updatingStatistics(teamTwoName, 0, 1, 0, teamTwoScore, teamOneScore, 1, 1);
        }
        //creates a match object
        Match matchObj = new Match(teamOneName, teamOneScore, teamTwoName, teamTwoScore, date);
        //adding the match object to the arrayList
        matchArrayList.add(matchObj);
        savingDataToFile("Club details.ser", "Match details.ser");

    }

    public void updatingStatistics(String name, int wins, int draws, int defeats, int gScored, int gReceived, int points, int matchesPlayed){
        //loops the arrayList that has the details about the club details and changes the data in the record we want alter
        for (FootballClub footballClub : footballClubArrayList) {
            if (footballClub != null && footballClub.getNameOfClub() != null) {
                if (footballClub.getNameOfClub().equals(name)) {
                    footballClub.setNoOfWins(wins);
                    footballClub.setNoOfDraws(draws);
                    footballClub.setNoOfDefeats(defeats);
                    footballClub.setNoOfGoalsScored(gScored);
                    footballClub.setNoOfGoalsReceived(gReceived);
                    footballClub.setNoOfPoints(points);
                    footballClub.setNoOfMatchesPlayed(matchesPlayed);
                    break;
                }
            } else {
                System.out.println("Its an null value");
            }
        }
    }

    //method to write the data to a file
    public void savingDataToFile(String clubFile, String matchFile) throws IOException{
        //saving the data about the club details to the file
        FileOutputStream fileOut = new FileOutputStream(clubFile);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for(FootballClub arrayListRecord : footballClubArrayList){
            if(arrayListRecord != null){
                out.writeObject(arrayListRecord);
            }
        }
        System.out.println("Saved details about the Clubs to the file.");

        //saving the data about the match details to the file
        FileOutputStream fileOutOne = new FileOutputStream(matchFile);
        ObjectOutputStream outOne = new ObjectOutputStream(fileOutOne);
        for(Match arrayListRecord : matchArrayList){
            if(arrayListRecord != null){
                outOne.writeObject(arrayListRecord);
            }
        }
        System.out.println("Saved details about the Matches to the file.");
        outOne.close();
        fileOutOne.close();
        out.close();
        fileOut.close();
    }

    //method to read the data from a file
    public void loadingDataFromFile(String clubFile, String matchFile) throws IOException, ClassNotFoundException{
        //loading the data from the file about the club details
        footballClubArrayList.clear();
        try{
            FileInputStream fileIn = new FileInputStream(clubFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (true) {
                try {
                    FootballClub c = (FootballClub) in.readObject();
                    footballClubArrayList.add(c);
                } catch (EOFException | ClassCastException e) {
                    System.out.println("This is the end of the club details file. All data have been transmitted to the arrayList from the file");
                    System.out.println();
                    in.close();
                    fileIn.close();
                    break;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File does not exists. Or data hasn't been added yet.");
        }

        //loading the data from the file about the match details
        matchArrayList.clear();
        try{
            FileInputStream fileIn = new FileInputStream(matchFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (true) {
                try {
                    Match c = (Match) in.readObject();
                    matchArrayList.add(c);
                } catch (EOFException | ClassCastException e) {
                    System.out.println("This is the end of the match details file. All data have been transmitted to the arrayList from the file");
                    System.out.println();
                    in.close();
                    fileIn.close();
                    break;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File does not exists. Or data hasn't been added yet.");
        }
    }

    public boolean checkTeam(String clubNameEntered){
        //loops the arrayList that has the details about the club details and returns true if the club the user entered is found
        boolean isPresent = false;
        for(FootballClub arrayListRecord : footballClubArrayList) {
            if(arrayListRecord != null && arrayListRecord.getNameOfClub() != null){ //checks if the object is null or the name is null
                if(arrayListRecord.getNameOfClub().equals(clubNameEntered)){
                    isPresent =true;
                    break;
                }
            } else {System.out.println("Its an null value");}
        }
        return isPresent;
    }

    public boolean validatingString(String word){
        boolean isValid = true;
        //loops for the length of the word and checks if each character has space, capital letter or a simple letter.
        for(int i=0; i<word.length(); i++){
            if(!((word.charAt(i) >= 'A' && word.charAt(i) >= 'Z') || (word.charAt(i) >= 'a' && word.charAt(i) >= 'z') || word.contains(" "))){
                isValid = false;    //returns false if the the word is not valid
                break;
            }
        }
        return isValid;
    }

    public List<FootballClub> clubsSortedAccordingToPoints() throws IOException, ClassNotFoundException {
        loadingDataFromFile("Club details.ser", "Match details.ser");
        ArrayList<FootballClub> tempArrayList = new ArrayList<>();   //creates a temporary arrayList
        if(footballClubArrayList.size() == 0){
            System.out.println("No clubs added to the Premiere League");
        }else{
            tempArrayList.addAll(footballClubArrayList);      //assign all the records in footballClubArrayList to tempArrayList
            Collections.sort(tempArrayList, new PointsComparator());  //sorts the clubs according to the number of points
        }
        return tempArrayList;
    }

    public List<FootballClub> clubsSortedAccordingToGoalsScored() throws IOException, ClassNotFoundException {
        loadingDataFromFile("Club details.ser", "Match details.ser");
        ArrayList<FootballClub> tempArrayList = new ArrayList<>();   //creates a temporary arrayList
        if(footballClubArrayList.size() == 0){
            System.out.println("No clubs added to the Premiere League");
        }else{
            tempArrayList.addAll(footballClubArrayList);      //assign all the records in footballClubArrayList to tempArrayList
            Collections.sort(tempArrayList, new GoalsScoredComparator());   //sorts the clubs according to the goals scored
        }
        return tempArrayList;
    }

    public List<FootballClub> clubsSortedAccordingToWins() throws IOException, ClassNotFoundException {
        loadingDataFromFile("Club details.ser", "Match details.ser");
        ArrayList<FootballClub> tempArrayList = new ArrayList<>();   //creates a temporary arrayList
        if(footballClubArrayList.size() == 0){
            System.out.println("No clubs added to the Premiere League");
        }else {
            tempArrayList.addAll(footballClubArrayList);      //assign all the records in footballClubArrayList to tempArrayList
            Collections.sort(tempArrayList, new WinsComparator());   //sorts the clubs according to the number of wins
        }
        return tempArrayList;
    }

    public List<String> generatingARandomMatch() throws IOException, ClassNotFoundException{
        loadingDataFromFile("Club details.ser", "Match details.ser");
        Match matchObj = new Match();
        ArrayList<String> tempArrayList = new ArrayList<>();   //creates a temporary arrayList
        if (footballClubArrayList.size() == 0) {    //checks if clubs have been added to the PremierLeague
            System.out.println("No clubs to generate a match. Add two or more clubs to generate a match.");
        } else {
            Random r = new Random();
            String date = "";
            int teamOneNum, teamTwoNum = 0;
            boolean loop = true, loop1 = true;
            teamOneNum = r.nextInt(footballClubArrayList.size());      //generates a random number for Team One
            while (loop) {
                teamTwoNum = r.nextInt(footballClubArrayList.size());   //generates a random number for Team Two
                if (!(teamOneNum == teamTwoNum))    //checks if both the teams are equal
                    loop = false;
            }
            int teamOneScore = r.nextInt(10);    //generates a random number for Team One Score
            int teamTwoScore = r.nextInt(10);      //generates a random number for Team Two Score
            String teamOneName = footballClubArrayList.get(teamOneNum).getNameOfClub();
            String teamTwoName = footballClubArrayList.get(teamTwoNum).getNameOfClub();

            while (loop1) {
                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();     //takes the current year
                int year = 2000 + (int) Math.round(Math.random() * (currentYear - 2000));    //generates a random year
                date = r.nextInt(32) + "/" + r.nextInt(13) + "/" + year;   //creates a random date
                if (matchObj.dateValidation(date)) {    //checks if the date is valid
                    checkingTheScenarioOfMatch(teamOneName, teamTwoName, teamOneScore, teamTwoScore, date);   //updates the footballClubArrayList and matchArrayList
                    loop1 = false;
                }
            }
            tempArrayList.add("Team One Name - " + teamOneName);
            tempArrayList.add("Team One Score - " + teamOneScore);
            tempArrayList.add("Team Two Name - " + teamTwoName);
            tempArrayList.add("Team Two Name - " + teamTwoScore);
            tempArrayList.add("Date - "+ date);
        }
        return tempArrayList;
    }

    public List<Match> sortingMatches() throws IOException, ClassNotFoundException {
        loadingDataFromFile("Club details.ser", "Match details.ser");
        ArrayList<Match> tempArrayList = new ArrayList<>();   //creates a temporary arrayList
        if(matchArrayList.size() == 0){
            System.out.println("No clubs added to the Premiere League");
        }else{
            tempArrayList.addAll(matchArrayList);      //assign all the records in matchArrayList to tempArrayList
            Collections.sort(tempArrayList, new DateComparator());   //sorts the tempArrayList according to the date
        }
        return tempArrayList;
    }

    public List<Match> searchingAMatch(String searchDate) throws IOException, ClassNotFoundException {
        loadingDataFromFile("Club details.ser", "Match details.ser");
        //creates a list with the filtered matches according to the date entered by the user
        List<Match> tempList = matchArrayList.stream().filter(match -> match.getDate().equals(searchDate)).collect(Collectors.toList());
        //if the list contains no matches a label is shown
        if(tempList.size() == 0){
            System.out.println("No matches to display");
        }
        return tempList;
    }
}


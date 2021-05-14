package entities;

import services.PremierLeagueManager;
import java.io.IOException;
import java.util.Scanner;

public class  Menu{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        PremierLeagueManager premierLeagueManagerObj = new PremierLeagueManager();

        Scanner optionScanner = new Scanner(System.in);
        System.out.println("                                        ------------------------------------WELCOME------------------------------------");
        System.out.println();
        System.out.println("The functions of the system are as follow:");
        System.out.println();
        //calling the method to read the data from a file
        premierLeagueManagerObj.loadingDataFromFile("Club details.ser", "Match details.ser");
        boolean loop = true;
        //the main menu of the program starts here
        while (loop){
            System.out.println(" 1 - Create a new football club and add it in the premier league" +
                    "\n 2 - Delete (relegate) an existing club from the premier league" +
                    "\n 3 - Displaying the various statistics for a selected club" +
                    "\n 4 - Display the Premier League Table" +
                    "\n 5 - Adding a played match with its score and its date" +
                    "\n 6 - Saving in a file of all the information entered by the user" +
                    "\n 7 - Loading the data in a file of all the information entered by the user" +
                    "\n 8 - Graphical User Interface --->" +
                    "\n          Display the list (table) of all the teams in descending order of points" +
                    "\n        Display the list (table) of all the teams in descending order according to the Goals Scored" +
                    "\n        Display the list (table) of all the teams according to the largest number of wins (descending order)" +
                    "\n        Generating a random match when a button is pressed" +
                    "\n        Displaying all the matches played according to the ascending order of the dates" +
                    "\n        Displaying all the matches played for a particular date" +
                    "\nQ - Quit from the system");
            System.out.print("Please choose an option: ");           //asks the user which function he want to perform
            String option = optionScanner.nextLine();
            option = option.toUpperCase();
            switch (option){
                case "1":
                    premierLeagueManagerObj.addTeam();   //calling the method which adds a football team
                    break;
                case "2":
                    premierLeagueManagerObj.deleteTeam();   //calling the method which deletes a football team
                    break;
                case "3":
                    premierLeagueManagerObj.displayingStatisticsForAClub();   //calling the method which shows the statistics of a football team
                    break;
                case "4":
                    premierLeagueManagerObj.displayingPremierLeagueTable();  //calls the method which displaying Premier League Table
                    break;
                case "5":
                    premierLeagueManagerObj.addMatch();   //calls the method which adds a played match between two clubs
                    break;
                case "6":
                    //calling the method to write the data to a file
                    premierLeagueManagerObj.savingDataToFile("Club details.ser", "Match details.ser");
                    break;
                case "7":
                    premierLeagueManagerObj.loadingDataFromFile("Club details.ser", "Match details.ser");
                    break;
                case"G":
                    System.out.println("Launching the Graphical User Interface.");
                    String connectToGUI = "http://localhost:4200/";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(connectToGUI));
                    break;
                case "Q":
                    //quits the user from the program
                    System.out.println("Your quiting the program.");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option entered.");
                    System.out.println();
            }
            System.out.println();
        }
    }
}

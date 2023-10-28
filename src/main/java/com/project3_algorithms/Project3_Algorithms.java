package com.project3_algorithms;
import java.util.Scanner;
import java.util.Stack;

/**
 * Main Class for Project 3
 *
 * @author Jacob Bender and Christian Eppich
 * @version 1.0
 * Created 10/10/2023
 * Summary of Modifications:
 *
 * Description: Main class where testing for project3 is outlined and executed.
 *  Main takes in dimensions for the galaxy, how many months pass, and what 
 *  dominions secede from the galaxy in a given month. It then reverses the list
 *  of months using a stack and calls on functionalities of the Galaxy class to 
 *  add dominions. It prints how many months the galaxy was disconnected. 
 */
public class Project3_Algorithms {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        //Get dimensions of galaxy
        int n = inputScanner.nextInt();
        int m = inputScanner.nextInt();
        int k = inputScanner.nextInt();

        //Create galaxy with given dimensions
        Galaxy myGalaxy = new Galaxy(k,m,n);
        
        //Receive number of months
        int numMonths = inputScanner.nextInt();
        
        //Use stack to reverse order of months
        Stack<int[]> Calendar = new Stack<>();  
        
        //Input the months into the stack
        for (int i = 0; i < numMonths; i++){
            int numDoms = inputScanner.nextInt();
            int[] dominionList = new int [numDoms];
            for (int j = 0; j < numDoms; j++){
                dominionList[j] = inputScanner.nextInt();
            }
            Calendar.push(dominionList);
        }
        
        int countOfDisconnectedMonths = 0;
        
        for (int i = 0; i < numMonths; i++){
            //For each month, add every dominion to the galaxy
            int[] dominionList = Calendar.pop();
            for (int j = 0; j < dominionList.length; j++){
                //Call Galaxy function to add, check for neighbors, and maybe union
                myGalaxy.addDominion(dominionList[j]);
            }
            
            //Check if the galaxy is disconnected
            if (myGalaxy.getCountOfSets() > 1){
                countOfDisconnectedMonths++;
            }
        }
        
        //Print results
        System.out.println(countOfDisconnectedMonths);
    }
}

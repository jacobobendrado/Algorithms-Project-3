package com.project3_algorithms;
import java.util.Scanner;
import java.util.Stack;

//
/**
 * MainClass for Project 3
 *
 * @author Jacob Bender and Christian Eppich
 * @version 1.0
 * Created 10/10/2023
 * Summary of Modifications:
 *
 * Description: Main class where testing for project3 is outlined and executed.
 * 
 * 
2 2 3 9 
2 4 5 
3 6 8 10 
1 7 
1 2 
1 11 
1 9 
1 1 
1 0
 1 3
 */
public class Project3_Algorithms {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        //get dimensions of galaxy
        int n = inputScanner.nextInt();
        int m = inputScanner.nextInt();
        int k = inputScanner.nextInt();

        //create galaxy with given dimensions
        Galaxy myGalaxy = new Galaxy(k,m,n);
        
        //recieve number of dominions
        int numMonths = inputScanner.nextInt();
        
        //add dominions to stack
        Stack<int[]> Calendar = new Stack<>();  
        
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
            int[] dominionList = Calendar.pop();
            for (int j = 0; j < dominionList.length; j++){
                myGalaxy.addDominion(dominionList[j]);

            }
            if (myGalaxy.getCountOfSets()!=1){
                countOfDisconnectedMonths++;
            }
        }
        
        //Print results
        System.out.println(countOfDisconnectedMonths);
        
        
    }
}

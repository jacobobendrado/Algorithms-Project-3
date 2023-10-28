package com.project3_algorithms;

/**  
*   This is a class that simulates a galaxy
* 
*   @author Jacob Bender and Christian Eppich
*   @version 1.0 
*    File: Galaxy.java 
*    Created: 2023-10-28
*    ©Copyright Cedarville University, its Computer Science faculty, and the  
*    authors.  All rights reserved. 
* 
*   Description: This class uses a 3D array of Dominions to simulate a galaxy. 
*    It keeps track of how many sets are currently in use, but the dominions
*    themselves have to keep track of which set they're a part of. It has an
*    addDominion function that adds, checks for neighbors, and unions if 
*    necessary. Those functions are also publicly available individually.
*/
public class Galaxy {
    private int k, m, n;
    private Dominion[][][] galaxy;
    private int countOfSets;
    
    /**
     * Constructor
     * @param kk
     * @param mm
     * @param nn
     */
    public Galaxy(int kk, int mm, int nn) {
        n = nn;
        m = mm;
        k = kk;
        countOfSets = 0;
        
        galaxy = new Dominion[k][m][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    galaxy[i][j][l] = new Dominion(i, j, l);
                }
            }
        }
    }
    
    /**
     * Getter for count of sets
     * @return The number of active sets
     */
    public int getCountOfSets(){
        return countOfSets;
    }
    
    /**
     * Make a new set, then find and union each neighbor
     * @param dominionID The ID of the dominion being added
     */
    public void addDominion(int dominionID) {
        //Make a new set with just our new dominion
        Dominion currDominion = makeSet(dominionID);
        
        //While a neighbor exists that is a part of a different set, union together
        while (findNeighbor(currDominion) != null) {
            union(findNeighbor(currDominion), currDominion);
        }
    }

    /**
     * Combine two sets
     * @param first First set
     * @param second Second set
     */
    public void union (Dominion first, Dominion second) {
        //Get reps of both
        Dominion firstRep = first.getRepresentative();
        Dominion secondRep = second.getRepresentative();
        
        //Find which set is of a greater rank and merge the smaller set into it
        if (firstRep.getRank() > secondRep.getRank()) {
            secondRep.setRepresentative(firstRep);
        } else if (firstRep.getRank() < secondRep.getRank()){
            firstRep.setRepresentative(secondRep);
        } else {
            //If it's a tie, pick the first set as the winner and increase its rank
            secondRep.setRepresentative(firstRep);
            firstRep.setRank(firstRep.getRank()+1);
        }
        
        //Decrease how many sets we have
        countOfSets--;
    }

    /**
     * Make a new set
     * @param dominionID The ID of the dominion being added
     * @return The Dominion corresponding to the ID given
     */
    public Dominion makeSet(int dominionID){
        //Calculate the k, m, and n values of the local dominion
        int id = dominionID;
        int kk = id /(m * n);
        id = id - (kk * m * n);
        int mm = id / n;
        int nn = id % n;
        
        //Set the dominion to be its own representative of the new set
        Dominion currDominion = galaxy[kk][mm][nn];
        currDominion.setRepresentative(currDominion);
        currDominion.setRank(1);
        
        //Increase the number of sets
        countOfSets++;
        
        return currDominion;
    }
            
    

    /**
     * Find a dominion
     * @param dominionID The ID of the dominion being sought after
     * @return The Dominion corresponding to the ID given
     */
    public Dominion findDominion(int dominionID){
        //Calculate the k, m, and n values of the local dominion
        int id = dominionID;
        int kk = id /(m * n);
        id = id - (kk * m * n);
        int mm = id / n;
        int nn = id % n;
        
        //Return the requested dominion
        return galaxy[kk][mm][nn];
    }
    
    /**
     * Find the first neighbor of a given dominion from a different set
     * @param currDominion The dominion that is being searched around
     * @return The first neighbor that is part of a different set
     */
    public Dominion findNeighbor(Dominion currDominion){
        //Get the coords of our dominion
        int kk = currDominion.getK();
        int mm = currDominion.getM();
        int nn = currDominion.getN();
        
        //Find what set our dominion is a part of
        Dominion currRep = currDominion.getRepresentative();
            
        //Check in every direction if a neighboring dominion is part of another set
        if (validOption(kk+1, mm, nn, currRep)){
            return galaxy[kk+1][mm][nn];
        }
        if (validOption(kk-1, mm, nn, currRep)){
            return galaxy[kk-1][mm][nn];
        }
        if (validOption(kk, mm+1, nn, currRep)){
            return galaxy[kk][mm+1][nn];
        }
        if (validOption(kk, mm-1, nn, currRep)){
            return galaxy[kk][mm-1][nn];
        }
        if (validOption(kk, mm, nn+1, currRep)){
            return galaxy[kk][mm][nn+1];
        }
        if (validOption(kk, mm, nn-1, currRep)){
            return galaxy[kk][mm][nn-1];
        }
        
        //If none can be found, return null
        return null;
    }
    
    //See if given dominion is part of a different set
    private boolean validOption(int kk, int mm, int nn, Dominion currRep){
        //Make sure coords are within the galaxy
        if (kk < 0 || mm < 0 || nn < 0 || kk >= k || mm >= m || nn >= n){
            return false;
        }
        
        //See if the other dominion is part of a set
        if (galaxy[kk][mm][nn].getRepresentative() == null){
            return false;
        }
        
        //See if the other dominion is part of our set
        if (galaxy[kk][mm][nn].getRepresentative() == currRep){
            return false;
        }
        
        return true;
    }
    
}

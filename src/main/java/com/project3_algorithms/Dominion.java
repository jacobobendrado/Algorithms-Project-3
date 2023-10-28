package com.project3_algorithms;

/**  
*   This is a class that simulates a dominion
* 
*   @author Jacob Bender and Christian Eppich
*   @version 1.0 
*    File: Dominion.java 
*    Created: 2023-10-28
*    ©Copyright Cedarville University, its Computer Science faculty, and the  
*    authors.  All rights reserved. 
* 
*   Description: This class keeps track of an individual dominion. It knows its
*    location and its parent as well as its rank.
*/
public class Dominion {
    
    private int k, m, n;
    private Dominion parent;
    private int rank;
    
    //Constructor
    public Dominion(int kk, int mm, int nn) {
        n = nn;
        m = mm;
        k = kk;
        parent = null;
        rank = 0;
    }
    
    //Getter for k
    public int getK() {
        return k;
    }
    
    //Getter for m
    public int getM() {
        return m;
    }
    
    //Getter for n
    public int getN() {
        return n;
    }
    
    //Getter for representative
    public Dominion getRepresentative() {
        //Compress the path to easily get the representative recursively
        if (parent != null && parent != this) {
            parent = parent.getRepresentative();
        }
        
        return parent;
    }
    
    //Getter for rank
    public int getRank() {
        return rank;
    }
    
    //Setter for representative
    public void setRepresentative(Dominion newRep) {
        parent = newRep;
    }
    
    //Setter for rank
    public void setRank(int newRank) {
        rank = newRank;
    }
    
}


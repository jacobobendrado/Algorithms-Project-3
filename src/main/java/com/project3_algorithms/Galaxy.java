/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3_algorithms;

/**
 *
 * @author jacob
 */
public class Galaxy {
    private int k, m, n;
    private Dominion[][][] galaxy;
    private int countOfSets;
    
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
    
    public int getCountOfSets(){
        return countOfSets;
    }
    
    public void addDominion(int dominionID) {
        Dominion currDominion = makeSet(dominionID);
        while (findNeighbors(currDominion) != null) {
            union(findNeighbors(currDominion), currDominion);
        }
    }
        
    //merge two sets together
    public void union (Dominion first, Dominion second) {
        //getreps of both
        Dominion firstRep = first.getRepresentative();
        Dominion secondRep = second.getRepresentative();
        
        if (firstRep.getRank() > secondRep.getRank()) {
            secondRep.setRepresentative(firstRep);
        } else if (firstRep.getRank() < secondRep.getRank()){
            firstRep.setRepresentative(secondRep);
        } else {
            secondRep.setRepresentative(firstRep);
            firstRep.setRank(firstRep.getRank()+1);
        }
        countOfSets--;
    }
    
    //intialze a dominion
    public Dominion makeSet(int dominionID){
        int cd = dominionID;
        int kk = cd/(m*n);
        cd = cd - (kk*m*n);
        int mm = cd/n;
        int nn = cd%n;
        
        Dominion currDominion = galaxy[kk][mm][nn];
        currDominion.setRepresentative(currDominion);
        currDominion.setRank(1);
        
        countOfSets++;
        
        return currDominion;
    }
            
    //give a dominion whos is daddy
    //public Dominion FindSet()
    
    private Dominion findNeighbors(Dominion currDominion){
        int kk = currDominion.getK();
        int mm = currDominion.getM();
        int nn = currDominion.getN();
        
        Dominion currRep = currDominion.getRepresentative();
            
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
        return null;
    }
    
    private boolean validOption(int kk, int mm, int nn, Dominion currRep){
        if (kk < 0 || mm < 0 || nn < 0 || kk >= k || mm >= m || nn >= n){
            return false;
        }
        if (galaxy[kk][mm][nn].getRepresentative() == null){
            return false;
        }
        if (galaxy[kk][mm][nn].getRepresentative() == currRep){
            return false;
        }
        return true;
    }
    
}

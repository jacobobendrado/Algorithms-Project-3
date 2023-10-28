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
    
    public void addDominion(int dominionID) {
        Dominion currDominion = makeSet(dominionID);
        while (findNeighbors(currDominion) != null) {
            union(findNeighbors(currDominion), currDominion);
        }
        
    }
        
    //merge two sets together
    public Dominion union (Dominion first, Dominion second) {
        
        
        countOfSets--;
    }
    
    //intialze a dominion
    public Dominion makeSet(int dominionID){
        int cd = currentDominion;
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
        
    }
}

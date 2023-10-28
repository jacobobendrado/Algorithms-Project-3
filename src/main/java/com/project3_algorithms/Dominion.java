package com.project3_algorithms;

/**
 *
 * @author jacob
 */
public class Dominion {
    
    private int k, m, n;
    private Dominion parent;
    private int rank;
    
    public Dominion(int kk, int mm, int nn) {
        n = nn;
        m = mm;
        k = kk;
        parent = null;
        rank = 0;
    }
    
    public int getK() {
        return k;
    }
    
    public int getM() {
        return m;
    }
    
    public int getN() {
        return n;
    }
    
    public Dominion getRepresentative() {
        if (parent != null && parent != this) {
            parent = parent.getRepresentative();
        }
        return parent;
    }
    
    public int getRank() {
        return rank;
    }
    
    public void setRepresentative(Dominion newRep) {
        parent = newRep;
    }
    
    public void setRank(int newRank) {
        rank = newRank;
    }
    
}


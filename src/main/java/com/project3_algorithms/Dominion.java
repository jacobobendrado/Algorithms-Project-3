package com.project3_algorithms;

/**
 *
 * @author jacob
 */
public class Dominion {
    
    private int n, m, k;
    private Dominion representative;
    private Dominion parent;
    private int rank;
    
    public Dominion(int nn, int mm, int kk) {
        n = nn;
        m = mm;
        k = kk;
        parent = null;
        representative = null;
        rank = 0;
    }
    
    public int[] getPosition() {
        return new int[] {n, m, k};
    }
    
    public Dominion getRepresentative() {
        return compressPath();
    }
    
    public int getRank() {
        return rank;
    }
    
    public void setRepresentative(Dominion newRep) {
        compressPath().parent = newRep;
    }
    
    public void setRank(int newRank) {
        rank = newRank;
    }
    
    
    private Dominion compressPath() {
        if (parent != null && parent != this) {
            parent = parent.compressPath();
            representative = parent;
        }
        return parent;
    }
}


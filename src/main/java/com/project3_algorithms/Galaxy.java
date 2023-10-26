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
    private int n, m, k;
    private Dominion[][][] galaxy;
    
    public Galaxy(int nn, int mm, int kk) {
        n = nn;
        m = mm;
        k = kk;
        
        galaxy = new Dominion[k][m][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    galaxy[i][j][l] = new Dominion();
                }
            }
        }
    }
    
    //public Dominion Union ()
    
    //public Dominion MakeSet()
            
    //public Dominion FindSet()
    
}

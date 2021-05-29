/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 */
public class nCrModp {

    static int nCrModp(int n, int r, int p) {
        // The array C is going to store last row of
        // pascal triangle at the end. And last entry
        // of last row is nCr
        int C[] = new int[r + 1];

        C[0] = 1; // Top row of Pascal Triangle

        // One by constructs remaining rows of Pascal
        // Triangle from top to bottom
        for (int i = 1; i <= n; i++) {
            // Fill entries of current row using previous
            // row values
            for (int j = Math.min(i, r); j > 0; j--) {
                // nCj = (n-1)Cj + (n-1)C(j-1);
                C[j] = (C[j] + C[j - 1]) % p;
            }
        }
        return C[r];
    }

    public static void main(String args[]) {
        int n = 10, r = 2, p = 13;
        System.out.println("Value of nCr % p is " + nCrModp(n, r, p));
    }

}

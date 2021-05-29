/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * @author djoshi
 *
 * Longest Palindromic subsequence
 *
 * https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 *
 * https://www.youtube.com/watch?v=_nCsPn7_OgI
 *
 * https://www.youtube.com/watch?v=U4yPae3GEO0
 *
 */
public class LPS {

    private static int LPS_Rec(String seq, int i, int j) {
        // Base Case 1: If there is only 1 character 
        if (i == j) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same 
        if (seq.charAt(i) == seq.charAt(j) && i + 1 == j) {
            return 2;
        }

        // If the first and last characters match 
        if (seq.charAt(i) == seq.charAt(j)) {
            return LPS_Rec(seq, i + 1, j - 1) + 2;
        }

        // If the first and last characters do not match 
        return Math.max(LPS_Rec(seq, i, j - 1), LPS_Rec(seq, i + 1, j));
    }

    private static int LPS_DP(String seq) {
        int n = seq.length();
        int L[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {

            for (int i = 0; i < n - cl + 1; i++) {

                int j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                } else if (seq.charAt(i) == seq.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
                }
            }
        }

        return L[0][n - 1];
    }

    public static void main(String args[]) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The length of the recursive lps is " + LPS_Rec(seq, 0, n - 1));
        System.out.println("The length of the DP lps is " + LPS_DP(seq));
    }
}

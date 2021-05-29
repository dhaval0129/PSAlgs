/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 *
 * Longest Palindromic Subsequence
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 *
 * http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
 *
 * Time Complexity O(n^2)
 *
 */
public class LPSeq {

    private static int lps(String seq) {
        int n = seq.length();
        int L[][] = new int[n][n];

        // Strings of length 1 are palindrome of lentgh 1
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1; // next character

                if (seq.charAt(i) == seq.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                } else if (seq.charAt(i) == seq.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = Math.max(L[i][j - 1], L[i+1][j]);
                }
            }
        }
        return L[0][n-1];
    }

    public static void main(String args[]) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The length of the lps is " + lps(seq));
    }

}

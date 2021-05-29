/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.hard;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 *
 * https://www.youtube.com/watch?v=lDYIvtBVmgo
 *
 * https://www.youtube.com/watch?v=WPr1jDh3bUQ
 *
 * Refer: http://www.geeksforgeeks.org/?p=15553
 *
 * Palindrome Partitioning
 *
 * (Refer: Matrix Chain Multiplication for recursive approach)
 *
 * Given String is partitioned in such a way that every sub-string partitioned
 * is palindrome determine few cuts needed for palindrome partitioning.
 *
 * Time Complexity O(n^2)
 */
public class PalindromePartioning {

    private static int minPalPartition(String str) {
        // Get the length of the string
        int n = str.length();

        /* Create two arrays to build the solution
           in bottom up manner
           C[i][j] = Minimum number of cuts needed 
                     for palindrome partitioning
                     of substring str[i..j]
           P[i][j] = true if substring str[i..j] is
                     palindrome, else false
           Note that C[i][j] is 0 if P[i][j] is true 
         */
        int[] C = new int[n];
        boolean[][] P = new boolean[n][n];

        //Every substring of length 1 is palindrome
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }

        /* 
        L is substring length. Build the solution in
        bottom up manner by considering all substrings
        of length starting from 2 to n. The loop 
        structure is same as Matrx Chain Multiplication
        problem (See http://www.geeksforgeeks.org/archives/15553 )
         */
        for (int L = 2; L <= n; L++) {
            // For substring of length L, set different 
            // possible starting indexes
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1; // Set ending index

                // If L is 2, then we just need to 
                // compare two characters. Else need to
                // check two corner characters and value 
                // of P[i+1][j-1]
                if (L == 2) {
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    P[i][j] = (str.charAt(i) == str.charAt(j) && P[i + 1][j - 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (P[0][i] == true) {
                C[i] = 0;
            } else {
                C[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (P[j + 1][i] == true && 1 + C[j] < C[i]) {
                        C[i] = 1 + C[j];
                    }
                }
            }
        }

        return C[n - 1];
    }

    public static void main(String args[]) {
//        String str = "ababbbabbababa";
        String str = "abcbm";
        System.out.println("Min cuts needed for Palindrome Partitioning: " + minPalPartition(str));
    }
}

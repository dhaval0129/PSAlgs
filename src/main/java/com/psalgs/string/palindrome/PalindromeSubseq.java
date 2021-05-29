/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.palindrome;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
 *
 * Count All Palindromic Subsequence in a given String (need not necessarily be
 * distinct)
 *
 * Time Complexity : O(N ^ 2)
 *
 */
public class PalindromeSubseq {

    private static int countPS_Rec(String str, int i, int j) {
        if (i == j) {
            return 1; // palindrome of length 1
        } else if (str.charAt(i) == str.charAt(j)) {
            return countPS_Rec(str, i + 1, j) + countPS_Rec(str, i, j - 1) + 1;
        } else {
            return countPS_Rec(str, i + 1, j)
                    + countPS_Rec(str, i, j - 1) - countPS_Rec(str, i + 1, j - 1);
        }
    }

    private static int countPS_DP(String str) {
        int N = str.length();

        // create a 2D array to store the count of palindromic subsequence
        int[][] cps = new int[N + 1][N + 1];

        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++) {
            cps[i][i] = 1;
        }

        // check subsequence of length L is palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i < N; i++) {
                int k = L + i - 1;

                if (k < N) {
                    if (str.charAt(i) == str.charAt(k)) {
                        cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1;
                    } else {
                        cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
                    }
                }
            }
        }

        // return total palindromic subsequence
        return cps[0][N - 1];
    }

    public static void main(String args[]) {
        String str = "aab";
        int n = str.length() - 1;
        System.out.println("Total palindromic subsequence are : " + countPS_Rec(str, 0,n));
//        System.out.println("Total palindromic " + "subsequence are : " + countPS_DP(str));
    }
}

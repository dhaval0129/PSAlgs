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
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * https://www.youtube.com/watch?v=NnD96abizww
 * 
 * Longest Common Subsequence 
 *
 */
public class LCS {

    // O(2^n) 
    static int LCS_Rec(String A, String B) {
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        // check if last characters are same
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            // Add 1 to the result and remove the last character from both
            // the strings and make recursive call to the modified strings.
            return 1 + LCS_Rec(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
        } else {
            // Remove the last character of String 1 and make a recursive
            // call and remove the last character from String 2 and make a
            // recursive and then return the max from returns of both recursive
            // calls
            return Math.max(
                LCS_Rec(A.substring(0, lenA - 1), B.substring(0, lenB)),
                LCS_Rec(A.substring(0, lenA), B.substring(0, lenB - 1)));
        }
    }

    // O( m * n )
    // bottom up approach
    static int LCSeq_DP(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String a = "ABCD";
        String b = "AEBD";

        System.out.println("Recursion: "+LCS_Rec(a, b));
        System.out.println("Dynamic Programming: "+LCSeq_DP(a, b));
    }

}

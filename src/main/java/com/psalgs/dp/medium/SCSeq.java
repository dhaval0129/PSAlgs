/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 *
 * @author djoshi

 http://www.geeksforgeeks.org/shortest-common-supersequence/

 Shortest Common Super-Sequence

 Two Strings str1 and str2, find the shortest string that has both str1 and
 str2 as subsequences

 SCSeq = Sum of length of both strings - LCSeq
 */
public class SCSeq {

    private static int shortestSuperSeq(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int len = LCS_DP(X, Y, m, n);
        //SCSupSeq = Sum of length of both strings - LCSeq
        return (m + n - len);
    }

    private static int LCS_DP(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String args[]) {
        String X = "geek";
        String Y = "eke";
        System.out.println("Length of the shortest super-sequence is " + shortestSuperSeq(X, Y));
    }
}

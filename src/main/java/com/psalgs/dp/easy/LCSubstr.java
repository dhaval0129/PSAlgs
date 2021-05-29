/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * @author djoshi

 http://www.geeksforgeeks.org/longest-common-substring/

 https://www.youtube.com/watch?v=BysNXJHzCEs

 Longest common substring

 Time Complexity: O( m * n ) Auxiliary Space: O( m * n )

 Note: Difference between LCSeq and LCSubstr is when there is no match we put
 0 in cell, In LCSubstr we take value max values from left and top cells, If there
 is match we grab values from diagonal cell and add 1 to it
 *
 *
 */
public class LCSubstr {

    private static int LCSubStr_DP(char X[], char Y[]) {
        int m = X.length;
        int n = Y.length;

        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;  // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = 1 + LCStuff[i - 1][j - 1];
                    result = Integer.max(result, LCStuff[i][j]);
                } else {
                    LCStuff[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String X = "abcdaf";
        String Y = "zbcdf";

        System.out.println("Length of Longest Common Substring is "
                + LCSubStr_DP(X.toCharArray(), Y.toCharArray()));
    }
}

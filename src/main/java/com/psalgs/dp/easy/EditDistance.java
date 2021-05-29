/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *
 * Given two strings str1 and str2 and below operations that can performed on
 * str1. Find minimum number of edits (operations) required to convert str1 into
 * str2.
 * 
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 *
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 *
 *
 *
 * @author djoshi
 */
public class EditDistance {

    private static int min(int a, int b, int c) {
        int res = Math.min(a, b);
        return Math.min(res, c);
    }

    private static int editDist_Rec(String str1, String str2, int m, int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) {
            return n;
        }

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) {
            return m;
        }

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist_Rec(str1, str2, m - 1, n - 1);
        }

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editDist_Rec(str1, str2, m, n - 1), // Insert
                editDist_Rec(str1, str2, m - 1, n), // Delete/Remove
                editDist_Rec(str1, str2, m - 1, n - 1) // Replace                     
        );
    }

    private static int editDist_DP(String str1, String str2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j;  // Min. operations = j
                } else if (j == 0) {
                    // If second string is empty, only option is to
                    // remove all characters of second string
                    dp[i][j] = i; // Min. operations = i
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If last characters are same, ignore last char
                    // and recur for remaining string
                    // take the diagonal value on 2D array
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If last character are different, consider all
                    // possibilities and find minimum of three from upper row
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
//        String str1 = "pale";
//        String str2 = "ple";
        System.out.println(editDist_DP(str1, str2, str1.length(), str2.length()));
    }

}

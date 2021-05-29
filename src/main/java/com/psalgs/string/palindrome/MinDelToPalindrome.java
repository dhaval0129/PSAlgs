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
 * http://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 *
 * Minimum number of deletions to make a string palindrome
 *
 * Time Complexity: O(n2)
 */
public class MinDelToPalindrome {

    private static int lps(String str) {
        int n = str.length();

        // Create a table to store
        // results of subproblems
        int L[][] = new int[n][n];

        // Strings of length 1
        // are palindrome of length 1
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        // Build the table. Note that the lower diagonal
        // values of table are useless and not filled in
        // the process. c1 is length of substring
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;

                if (str.charAt(i) == str.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = Integer.max(L[i][j - 1], L[i + 1][j]);
                }
            }
        }

        // length of longest palindromic subsequence
        return L[0][n - 1];
    }

    private static int minimumNumberOfDeletions(String str) {
        int n = str.length();

        // Find longest palindromic subsequence
        int len = lps(str);

        // After removing characters other than
        // the lps, we get palindrome.
        return (n - len);
    }

    public static void main(String args[]) {
//        String str = "geeksforgeeks";
        String str = "xbcb";
        System.out.println("Minimum number of deletions = " + minimumNumberOfDeletions(str));
    }
}

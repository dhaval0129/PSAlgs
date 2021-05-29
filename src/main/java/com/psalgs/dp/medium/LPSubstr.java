/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 * Longest Palindrome substring
 *
 * @author djoshi
 * 
 * Time Complexity O(n)
 */
public class LPSubstr {

    private static int longestPalSubstr(String str) {
        int n = str.length();
        boolean[][] T = new boolean[n][n];

        // length 1
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            T[i][i] = true;
        }

        // length 2
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                T[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // length greater than 2
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1; // next character in string

                if (T[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    T[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println("Longest palindrome substring is: "
                + str.substring(start, start + maxLength - 1));

        return maxLength;
    }

    public static String longestPalindrome_DP(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l; //next character
                // check if both characters are same 
                // and check if it is even or odd palindrome or last string as palindrome
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String args[]) {
        String str = "forgeeksskeegfor";
//        System.out.println("Length is: " + longestPalSubstr(str));
        System.out.println("Length is: " + longestPalindrome_DP(str));
    }

}

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
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 *
 * http://articles.leetcode.com/longest-palindromic-substring-part-i/
 *
 * Longest Palindromic Substring
 *
 * ( Given a string, find the longest substring which is palindrome )
 *
 * Time complexity: O ( n^2 ) 
 * Auxiliary Space: O ( 1 )
 */
public class LPS_Loop {

    // A utility function to print a substring str[low..high]
    private static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    private static int longestPalSubstr(String str) {
        int maxLength = 1; // The result (length of LPS_Loop)
        int start = 0;
        int len = str.length();
        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) {

            // Find the longest even length palindrome with 
            // center points as i-1 and i.
            low = i - 1;
            high = i;

            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with 
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
//        String str = "xabdbaf";
        System.out.println("Length is: " + longestPalSubstr(str));
    }
}

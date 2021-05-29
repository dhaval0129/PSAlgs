/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.patternsearch;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 *
 * Anagram Substring Search
 *
 */
public class AnagramSubstrSearch {

    private static final int MAX = 128;

    private static boolean compare(int arr1[], int arr2[]) {
        for (int i = 0; i < MAX; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create a ascii int array 
        int[] countP = new int[MAX];
        int[] countW = new int[MAX];

        // countP[]:  Store count of all characters of pattern
        // countTW[]: Store count of current window of text
        for (int i = 0; i < M; i++) {
            countP[pat.charAt(i)]++;
            countW[txt.charAt(i)]++;
        }

        for (int i = M; i < N; i++) {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countW)) {
                System.out.println("Found at Index: " + (i - M));
            }

            // Add current character to current window
            countW[txt.charAt(i)]++;

            // Remove the first character of previous window
            countW[txt.charAt(i - M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countW)) {
            System.out.println("Found at Index: " + (N - M));
        }
    }

    public static void main(String args[]) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(pat, txt);
    }
}

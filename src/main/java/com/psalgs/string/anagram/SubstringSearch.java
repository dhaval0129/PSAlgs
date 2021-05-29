/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.anagram;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 *
 * Anagram Substring Search (Or Search for all permutations)
 *
 */
public class SubstringSearch {

    private static final int MAX = 128;

    // This function returns true if contents
    // of arr1[] and arr2[] are same, otherwise
    // false.
    private static boolean compare(char arr1[], char arr2[]) {
        for (int i = 0; i < MAX; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // This function search for all permutations
    // of pat[] in txt[]
    private static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // countP[]:  Store count of all 
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];

        for (int i = 0; i < M; i++) {
            countP[pat.charAt(i)]++;
            countTW[txt.charAt(i)]++;
        }

        // Traverse through remaining characters of pattern
        for (int i = M; i <= N; i++) {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW)) {
                System.out.println("Found at Index " + (i - M));
            }
            
            // This condition is to check the last window in text
            // and break as there will no need to increment to next character
            // if incremented it will throw String indexoutof bounds exception
            if(i == N){
                break;
            }
            
            // Add current character to current window
            countTW[txt.charAt(i)]++;

            // Remove the first character of previous window
            countTW[txt.charAt(i - M)]--;
        }

//         Check for the last window in text
//        if (compare(countP, countTW)) {
//            System.out.println("Found at Index " + (N - M));
//        }
    }

    public static void main(String args[]) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(pat, txt);
    }
}

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
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 * 
 * Naive Pattern Searching
 * 
 * Time Complexity O(n ^ 2)
 */
public class NaivePatternSearch {

    private static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == M) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }

    public static void main(String args[]) {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(pat, txt);
    }
}

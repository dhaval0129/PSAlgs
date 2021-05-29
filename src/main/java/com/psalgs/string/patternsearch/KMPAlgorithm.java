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
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 *
 * KMP (Knuth Morris Pratt)
 * 
 * Searching for Patterns - Pattern Searching (Substring search) 
 *
 * Time Complexity O( m + n )
 * 
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * 
 * https://www.youtube.com/watch?v=KG44VoDtsAA
 *
 */
public class KMPAlgorithm {

    private static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]

        computeLPSArray(pat, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                System.out.println("Found Pattern at index " + (i - j));
                j = lps[j - 1];
            } else if ( i < N && pat.charAt(j) != txt.charAt(i)){
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }

    }

    private static void computeLPSArray(String pat, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
                if (len != 0) {
                    len = lps[len - 1];
                } else { // if (len == 0)
                    lps[i] = len;
                    i++;
                }
        }
    }

    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }
}

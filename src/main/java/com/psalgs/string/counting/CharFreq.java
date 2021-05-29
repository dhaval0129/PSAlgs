/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-if-frequency-of-all-characters-can-become-same-by-one-removal/
 *
 * Check if frequency of all characters can become same by one removal
 *
 * Time Complexity : O(n)
 */
public class CharFreq {

    private static final int MAX_CHAR = 26;

    private static boolean allSame(int freq[]) {
        int same = 0;
        int i = 0;
        int N = freq.length;

        for (i = 0; i < MAX_CHAR; i++) {
            if (freq[i] > 0) {
                same = freq[i];
                break;
            }
        }

        //  check equality of each element with variable same
        for (int j = i + 1; j < N; j++) {
            if (freq[j] > 0 && freq[j] != same) {
                return false;
            }
        }

        return true;
    }

    // Returns true if we can make all character
    // frequencies same
    private static boolean possibleSameCharFreqByOneRemoval(String str) {
        int len = str.length();
        //  fill frequency array
        int[] freq = new int[MAX_CHAR];

        for (int i = 0; i < len; i++) {
            freq[str.charAt(i) - 'a']++;
        }

        //  if all frequencies are same, then return true
        if (allSame(freq)) {
            return true;
        }

        /*  Try decreasing frequency of all character
            by one and then check all equality of all
            non-zero frequencies */
        for (char c = 'a'; c <= 'z'; c++) {
            int i = c - 'a';

            // Check character only if it occurs in str
            if (freq[i] > 0) {
                freq[i]--;

                if (allSame(freq)) {
                    return true;
                }
                freq[i]++;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String str = "xyyzz";
        if (possibleSameCharFreqByOneRemoval(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}

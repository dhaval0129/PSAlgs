/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
 *
 * Count number of substrings with exactly k distinct characters
 *
 * Time Complexity : O(n*n)
 *
 */
public class kDistinctChar {

    // Function to count number of substrings
    // with exactly k unique characters
    private int countKDist(String str, int k) {
        int res = 0;
        int n = str.length();
        int cnt[] = new int[26];

        for (int i = 0; i < n; i++) {
            int dist_count = 0;
            Arrays.fill(cnt, 0);

            for (int j = i; j < n; j++) {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k) {
                    res++;
                }
            }
        }
        
        return res;
    }

    public static void main(String args[]) {
        kDistinctChar kdc = new kDistinctChar();
        String ch = "abcbaa";
        int k = 3;

        System.out.println("Total substrings with extactly "
                + k + " distinct characters: " + kdc.countKDist(ch, k));
    }
}

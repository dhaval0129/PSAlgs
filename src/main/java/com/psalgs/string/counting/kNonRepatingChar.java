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
 * http://www.geeksforgeeks.org/kth-non-repeating-character/
 *
 * Kth Non-repeating Character
 *
 */
public class kNonRepatingChar {

    private static final int MAX_CHAR = 128;

    private static int kthNonRepeating(String str, int k) {
        int n = str.length();

        int[] count = new int[MAX_CHAR];
        int[] index = new int[MAX_CHAR];

        // Initialize counts of all characters and indexes
        // of non-repeating  characters.
        for (int i = 0; i < MAX_CHAR; i++) {
            count[i] = 0;
            index[i] = n;
        }

        // Traverse the input string
        for (int i = 0; i < n; i++) {
            char x = str.charAt(i);
            ++count[x];

            // If this is first occurrence, then set value
            // in index as index of it.
            if (count[x] == 1) {
                index[x] = i;
            }

            // If character repeats, then remove it from
            // index[]
            if (count[x] == 2) {
                index[x] = n;
            }
        }

        Arrays.sort(index);

        // After sorting, if index[k-1] is value, then 
        // return it, else return -1.
        return (index[k - 1] != n) ? index[k - 1] : -1;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        int k = 3;
        int res = kthNonRepeating(str, k);

        String s1 = "There are less than k non-repeating characters";
        String s2 = "k'th non-repeating character is  ";

        System.out.println(res == -1 ? s1 : s2 + str.charAt(res));
    }
}

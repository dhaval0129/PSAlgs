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
 * http://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
 *
 * Check if two strings are k-anagrams or not
 *
 * Two strings are called k-anagrams if following two conditions are true.
 *
 * Both have same number of characters and Two strings can become anagram by
 * changing at most k characters in a string.
 *
 */
public class kAnagrams {

    static final int MAX_CHAR = 26;

    private static boolean arekAnagrams(String str1, String str2, int k) {
        // If both strings are not of equal
        // length then return false
        int n = str1.length();
        if (str2.length() != n) {
            return false;
        }

        int[] count1 = new int[MAX_CHAR];
        int[] count2 = new int[MAX_CHAR];
        int count = 0;

        // Store the occurrence of all characters
        // in a hash_array
        for (int i = 0; i < n; i++) {
            count1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            count2[str2.charAt(i) - 'a']++;
        }

        // Count number of characters that are
        // different in both strings
        for (int i = 0; i < MAX_CHAR; i++) {
            if (count1[i] > count2[i]) {
                count += Math.abs(count1[i] - count2[i]);
            }
        }

        // Return true if count is equal to k
        return (count <= k);
    }

    public static void main(String args[]) {
        String str1 = "anagram";
        String str2 = "grammar";
        int k = 2;
        if (arekAnagrams(str1, str2, k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}

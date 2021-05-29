/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.anagram;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-pairs-anagrams-given-array-strings/
 *
 * Print all pairs of anagrams in a given array of strings
 *
 */
public class ArrayAnagrams {

    private static boolean areAnagram(char[] s1, char[] s2) {
        if (s1.length != s2.length) {
            return false;
        }

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

    private static void findAllAnagrams(String arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areAnagram(arr[i].toCharArray(), arr[j].toCharArray())) {
                    System.out.println(arr[i] + " is anagram of " + arr[j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = {"geeksquiz", "geeksforgeeks",
            "abcd", "forgeeksgeeks", "zuiqkeegs"};
        int n = arr.length;
        findAllAnagrams(arr, n);
    }
}

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
 * http://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-with-permutations-allowed/
 *
 * Minimum insertions to form a palindrome with permutations allowed
 *
 *
 */
public class PermutationsPalindrome {

    private static int minInsertion(String str) {
        // To store string length
        int n = str.length();

        // To store number of characters 
        // occurring odd number of times
        int res = 0;

        // To store count of each 
        // character
        int[] count = new int[26];

        // To store occurrence of each
        // character
        for (int i = 0; i < n; i++) {
            count[str.charAt(i) - 'a']++;
        }

        // To count characters with odd
        // occurrence
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                res++;
            }
        }

        // As one character can be odd return
        // res - 1 but if string is already
        // palindrome return 0
        return (res == 0) ? 0 : res - 1;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        System.out.println(minInsertion(str));
    }
}

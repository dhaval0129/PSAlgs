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
 * http://www.geeksforgeeks.org/number-distinct-permutation-string-can/
 *
 * Number of distinct permutation a String can have
 *
 */
public class DistinctPermutation {

    private static final int MAX_CHAR = 26;

    // Utility function to find factorial of n.
    static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static int countDistinctPermutations(String str) {
        int length = str.length();

        int[] freq = new int[MAX_CHAR];

        // finding frequency of all the lower case
        // alphabet and storing them in array of integer
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= 'a') {
                freq[str.charAt(i) - 'a']++;
            }
        }

        // finding factorial of number of appearances
        // and multiplying them since they are
        // repeating alphabets
        int fact = 1;
        for (int i = 0; i < MAX_CHAR; i++) {
            fact = fact * factorial(freq[i]);
        }

        // finding factorial of size of string and
        // dividing it by factorial found after
        // multiplying
        return factorial(length) / fact;
    }

    public static void main(String args[]) {
        String str = "fvvfhvgv";
        System.out.println(countDistinctPermutations(str));
    }
}

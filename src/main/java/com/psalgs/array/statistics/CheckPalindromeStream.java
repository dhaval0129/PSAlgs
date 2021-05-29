/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-stream/
 *
 * Online algorithm for checking palindrome in a stream
 *
 * Hint: Rolling Hash Rabin Karp Algorithm
 *
 * Time Complexity: O(n)
 */
public class CheckPalindromeStream {

    // Ascii table size
    private static final int d = 128;

    // Prime number used for rabin karp rolling hash
    private static final int q = 103;

    private static void checkPalindromes(String str) {
        // Length of input string
        int N = str.length();

        // A single character is always a palindrome
        System.out.println(str.charAt(0) + " Yes");

        // Return if string has only one character
        if (N == 1) {
            return;
        }

        // Initialize first half reverse and second half
        // for as first and second characters
        int first = str.charAt(0) % q;
        int second = str.charAt(1) % q;

        int h = 1, i, j;

        // Now check for palindromes from second character onward
        for (i = 1; i < N; i++) {
            // If hash values of 'first' and 'second' match 
            // then only check individual characters
            if (first == second) {
                // Check if str[0..i] is palindrome using
                // simple character by character match
//                for (j = 0; j < i / 2; j++) {
//                    if (str.charAt(j) != str.charAt(i - j)) {
//                        break;
//                    }
//                }
//                System.out.println((j == i / 2) ? str.charAt(i) + " Yes" : str.charAt(i) + " No");
                System.out.println(str.charAt(i) + " Yes");
            } else {
                System.out.println(str.charAt(i) + " No");
            }

            // Calculate hash values for next iteration
            // Don't calculate has for next characters if this is last character of string
            if (i != N - 1) {
                // If current i is even (than next is odd)
                if (i % 2 == 0) {
                    // Add next character after first half at beginning of 'first'
                    h = (h * d) % q;
                    first = (first + h * str.charAt(i / 2)) % q;
                    // Add next character after second half at the end of second half
                    second = (second * d + str.charAt(i + 1)) % q;
                } else {
                    // If current i is odd (next i is even) then we do not need to change first,
                    // we need to remove first character of second and append a next character to it.
                    second = (d * (second + q - str.charAt((i + 1) / 2) * h) % q + str.charAt(i + 1)) % q;
                }
            }
        }
    }

    public static void main(String args[]) {
        String txt = "aabaacaabaa";
        checkPalindromes(txt);
    }
}

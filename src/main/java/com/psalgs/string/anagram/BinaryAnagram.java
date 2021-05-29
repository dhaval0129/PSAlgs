/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.anagram;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-binary-representations-two-numbers-anagram/
 *
 * Check if binary representations of two numbers are anagram
 *
 */
public class BinaryAnagram {

    private static boolean bit_anagram_check(long a, long b) {
        // Long.bitCount(a) gives number of 1's present
        // in binary representation of a
        return (Long.bitCount(a) == Long.bitCount(b));
    }

    public static void main(String args[]) {
        long a = 8, b = 4;
        if (bit_anagram_check(a, b)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

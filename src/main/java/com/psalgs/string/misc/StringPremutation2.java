/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 *
 * http://javabypatel.blogspot.in/2015/07/program-to-print-permutations-of-string-with-repetition.html
 *
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 *
 * Print all permutations with repetition of characters ( backtracking example )
 *
 */
public class StringPremutation2 {

    private static void printPermutation(String str, String stringToPrint) {
        if (stringToPrint.length() == str.length()) {
            System.out.println(stringToPrint);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            printPermutation(str, stringToPrint + str.charAt(i));
        }
    }

    private static void printPermutationOfStrings(String str) {
        printPermutation(str, "");
    }

    public static void main(String args[]) {
        printPermutationOfStrings("ABC");
    }
}

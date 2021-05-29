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
 * http://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/
 *
 * Print all distinct characters of a string in order
 *
 */
public class DistinctChars {

    private static final int NO_OF_CHARS = 128;

    private static void printDistinct(String str) {
        int[] count = new int[NO_OF_CHARS];

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == ' ')) {
                count[str.charAt(i)]++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                System.out.print(str.charAt(i) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String str = "Geeks for Geeks";
        printDistinct(str);
    }
}

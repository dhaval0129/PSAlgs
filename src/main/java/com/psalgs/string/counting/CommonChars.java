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
 * http://www.geeksforgeeks.org/print-common-characters-two-strings-alphabetical-order-2/
 *
 * Print common characters of two Strings in alphabetical order
 *
 */
public class CommonChars {

    private static final int MAX_CHAR = 26;

    private static void printCommon(String s1, String s2) {
        int[] a1 = new int[MAX_CHAR];
        int[] a2 = new int[MAX_CHAR];

        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            a2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < MAX_CHAR; i++) {
            if (a1[i] != 0 && a2[i] != 0) {
                // Find the minimum of the occurence
                // of the character in both strings and print
                // the letter that many number of times
                for (int j = 0; j < Math.min(a1[i], a2[i]); j++) {
                    System.out.print(((char) (i + 'a')));
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String s1 = "geeksforgeeks", s2 = "practiceforgeeks";
        printCommon(s1, s2);
    }
}

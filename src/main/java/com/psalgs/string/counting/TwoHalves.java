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
 * http://www.geeksforgeeks.org/check-half-string-character-frequency-character/
 *
 * Check if both halves of the string have same set of characters
 *
 */
public class TwoHalves {

    private static final int MAX_CHAR = 26;

    private static boolean checkCorrectOrNot(String s) {
        int len = s.length();
        int[] count1 = new int[MAX_CHAR];
        int[] count2 = new int[MAX_CHAR];

        for (int i = 0; i < (len / 2); i++) {
            count1[s.charAt(i) - 'a']++;
            count2[s.charAt(len - 1 - i) - 'a']++;
        }

        // Checking if values are different set flag to false
        for (int i = 0; i < MAX_CHAR; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // String to be checked
        String s = "abab";

        if (checkCorrectOrNot(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

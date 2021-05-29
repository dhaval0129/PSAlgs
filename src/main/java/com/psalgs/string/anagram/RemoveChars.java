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
 * http://www.geeksforgeeks.org/remove-minimum-number-characters-two-strings-become-anagram/
 *
 * Remove minimum number of characters so that two strings become anagram
 *
 */
public class RemoveChars {

    private static final int NO_CHARS = 26;

    private static void removeChars(String s1, String s2) {
        int[] count = new int[NO_CHARS];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < NO_CHARS; i++) {
            if (count[i] != 0) {
                while (count[i] != 0) {
                    System.out.print((char)(i + 'a') + " ");
                    count[i]--;
                }
            }
        }
        
        System.out.println();
    }

    public static void main(String args[]) {
        String str1 = "bcadeh";
        String str2 = "hea";
        System.out.println("Original String");
        System.out.println(str1 + " " + str2);
        System.out.println("Chars that needs to removed to make string anagram");
        removeChars(str1, str2);
    }
}

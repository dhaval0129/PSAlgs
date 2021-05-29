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
 * http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 *
 * Check whether two strings are anagram of each other
 *
 */
public class CheckAnagram {

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

    public static void main(String args[]) {
        char str1[] = {'t', 'e', 's', 't'};
        char str2[] = {'t', 't', 'e', 'w'};
        if (areAnagram(str1, str2)) {
            System.out.println("The two strings are"
                    + " anagram of each other");
        } else {
            System.out.println("The two strings are not"
                    + " anagram of each other");
        }
    }
}

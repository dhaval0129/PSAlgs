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
 * http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 *
 * Given a string, find its first non-repeating character
 * 
 * Time Complexity O(n + n ) or O(2*n)
 */
public class FirstNonRepeatingChar {

    private static final int chars = 26;

    private static int firstNonRepeating(String str) {
        int len = str.length();
        int alphabet[] = new int[26];

        for (int i = 0; i < len; i++) {
            alphabet[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if(alphabet[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        String error = "Either all characters are repeating or string is empty";
        String success = "First non-repeating character: ";

        int index = firstNonRepeating(str);
        System.out.println(index == -1 ? error : success + str.charAt(index));
    }
}

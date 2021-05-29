/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

/**
 *
 * @author djoshi
 *
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another.
 *
 * Given two strings, sl and s2, write code to check if s2 is a rotation of sl
 * using only one call to isSubstring
 *
 * (e.g., "waterbottle" is a rotation of"erbottlewat").
 *
 * Time Complexity O( M * N ) where N is size of array 
 * and M is total number of rotations
 * 
 */
public class StringRotation {

    private static String rotateString(String s, int n) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n; i++) {
            rotateLeft(charArray);
        }

        return String.valueOf(charArray);
    }

    private static char[] rotateLeft(char[] charArray) {
        int len = charArray.length;

        char temp = charArray[0];
        for (int i = 0; i < len - 1; i++) {
            charArray[i] = charArray[i + 1];
        }

        charArray[len - 1] = temp;
        return charArray;
    }

    public static void main(String args[]) {
        String str = "waterbottle";
        int N = 3;
        System.out.println("Rotated String by " + N + " : " + rotateString(str, N));
    }
}

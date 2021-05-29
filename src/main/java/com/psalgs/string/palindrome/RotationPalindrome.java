/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.palindrome;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
 *
 * Check if a given string is a rotation of a palindrome
 *
 */
public class RotationPalindrome {

    private static boolean isPalindrome(String s) {
        int len = s.length();

        for (int i = 0; i < (len / 2); i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRotationPalindrome(String s) {
        int len = s.length();
        char[] str = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (!isPalindrome(s)) {
                return false;
            }

            // rotate the string
            char temp = str[0];
            for (int j = 1; j < str.length; j++) {
                str[j - 1] = str[j];
            }
            str[str.length - 1] = temp;
            s = new String(str);
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println((isRotationPalindrome("aaa")) ? 1 : 0);
        System.out.println((isRotationPalindrome("abcde")) ? 1 : 0);
        System.out.println((isRotationPalindrome("aaaad")) ? 1 : 0);
    }
}

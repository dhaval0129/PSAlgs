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
 * http://www.geeksforgeeks.org/c-program-check-given-string-palindrome/
 *
 * Check if a Given String is Palindrome
 *
 */
public class CheckPalindrome {

    private static boolean isPalindrome_Rec(String str, int s, int e) {
        // If there is only one character
        if( s > e) {
            return false;
        }
        
        if (s == e) {
            return true;
        }

        // If first and last characters do not match
        if ((str.charAt(s)) != (str.charAt(e))) {
            return false;
        }

        // If there are more than two characters,
        // check if middle substring is also
        // palindrome or not.
        if (s + 1 < e - 1 ) {
            return isPalindrome_Rec(str, s + 1, e - 1);
        }

        return true;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();

        for (int i = 0; i < (len / 2); i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("abcba is palindrome: " + isPalindrome_Rec("abcba", 0, "abcba".length() - 1));
        System.out.println("abbccbba is palindrome: " + isPalindrome("abbccbba"));
        System.out.println("geeks is palindrome: " + isPalindrome("geeks"));
    }
}

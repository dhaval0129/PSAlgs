/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-string-follows-anbn-pattern-not/
 *
 * Check if a string follows a^n*b^n pattern or not
 *
 */
public class StringPattern {

    private static boolean isAnBn(String s) {
        int l = s.length();

        if (l % 2 == 1) {
            return false;
        }

        int i = 0;
        int j = l - 1;

        // Compare the characters till the center
        while (i < j) {
            if (s.charAt(i) != 'a' || s.charAt(j) != 'b') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "abab";

        //Function call
        if (isAnBn(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

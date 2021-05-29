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
 * http://www.geeksforgeeks.org/check-binary-string-0-between-1s-not/
 *
 * Check if a binary string has a 0 between 1s or not
 *
 * Time Complexity : O(n)
 */
public class CheckValid {

    private static boolean checkString(String s) {
        int first = 0;
        int last = s.length();

        for (int i = 0; i < last; i++) {
            if (s.charAt(i) == '1') {
                first = i;
                break;
            }
        }

        for (int j = last - 1; j >= 0; j--) {
            if (s.charAt(j) == '1') {
                last = j;
                break;
            }
        }

        for (int k = first; k <= last; k++) {
            if (s.charAt(k) == '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "00011111111100000";
        System.out.println(checkString(s) ? "VALID" : "NOT VALID");
    }
}

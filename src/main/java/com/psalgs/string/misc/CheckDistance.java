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
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
 *
 * Check if edit distance between two strings is one
 *
 */
public class CheckDistance {

    private static boolean isEditDistanceOne(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        int count = 0;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) {
                    return false;
                }

                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            } else {
                i++;
                j++;
            }
        }

        // If last character is extra in any string
        if (i < m || j < n) {
            count++;
        }

        return count == 1;
    }

    public static void main(String args[]) {
        String s1 = "gfg";
        String s2 = "gf";
        System.out.println(isEditDistanceOne(s1, s2) ? "Yes" : "No");
    }
}

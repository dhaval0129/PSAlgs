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
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
 *
 * Check if two given strings are isomorphic to each other
 *
 * Two strings str1 and str2 are called isomorphic if there is a one to one
 * mapping
 *
 */
public class AreIsomorphic {

    private static final int MAX_CHARS = 128;

    private static boolean areIsomorphic(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m != n) {
            return false;
        }

        boolean[] marked = new boolean[MAX_CHARS];
        int[] map = new int[MAX_CHARS];

        for (int i = 0; i < n; i++) {
            if (map[s1.charAt(i)] == 0) {
                if (marked[s2.charAt(i)]) {
                    return false;
                }

                marked[s2.charAt(i)] = true;
                map[s1.charAt(i)] = s2.charAt(i);
            } else if (map[s1.charAt(i)] != s2.charAt(i)) {
                // If this is not first appearance of current
                // character in str1, then check if previous
                // appearance mapped to same character of str2
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        boolean res = areIsomorphic("aab", "xxy");
        System.out.println(res);

        res = areIsomorphic("aab", "xyz");
        System.out.println(res);
    }
}

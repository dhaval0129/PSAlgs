/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-characters-position-english-alphabets/
 *
 * Count characters at same position as in English alphabets
 *
 */
public class SamePos {

    private static int countAlphabetOrder(String s) {

        if (s.equals("") || s == null) {
            return 0;
        }

        int len = s.length();
        int res = 0;;
        
        for (int i = 0; i < len; i++) {

            if (i == s.charAt(i) - 'a' || i == s.charAt(i) - 'A') {
                res++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        String s = "alphabetical";
        System.out.println("Characters in Alphabetical Order: " + countAlphabetOrder(s));

    }

}

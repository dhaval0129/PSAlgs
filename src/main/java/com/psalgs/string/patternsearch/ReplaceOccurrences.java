/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.patternsearch;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/replace-occurrences-string-ab-c-without-using-extra-space/
 *
 * Replace all occurrences of string AB with C without using extra space
 */
public class ReplaceOccurrences {

    private static String translate(String str) {
        int len = str.length();
        String s = "";

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'A' && str.charAt(i + 1) == 'B') {
                s += 'C';
                i++;
            } else {
                s += str.charAt(i);
            }
        }
        return s;
    }

    public static void main(String args[]) {
        String str = "helloABworldABGfG";
        System.out.println("Translated String: "+translate(str));
    }
}

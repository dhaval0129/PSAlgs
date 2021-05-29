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
 * http://www.geeksforgeeks.org/print-string-specified-character-occurred-given-no-times/
 *
 * Print the string after the specified character has occurred given no. of
 * times
 *
 *
 */
public class SpecifiedChar {

    private static void printString(String str, char c, int r) {
        if (str.isEmpty()) {
            System.out.println("String is empty");
            return;
        }

        int len = str.length();
        int repeat = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == c && r != repeat) {
                repeat++;
            } else if (r == repeat) {
                System.out.println(str.substring(i));
                break;
            }
        }
    }

    public static void main(String args[]) {
        String str = "geeks for geeks";
        printString(str, 'e', 2);
    }
}

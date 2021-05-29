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
 * http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 *
 * Return maximum occurring character in an input string
 * 
 * Time Complexity: O(n)
 *
 */
public class MaxChars {

    static final int ASCII_SIZE = 128;

    private static String getMaxOccuringChar(String str) {
        int[] count = new int[ASCII_SIZE];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        int max = -1;
        char result = '\0';

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) i;
            }
        }

        return result + "";
    }

    public static void main(String args[]) {
        String str = "sample string";
        System.out.println("Max occurring character is " + getMaxOccuringChar(str));
    }
}

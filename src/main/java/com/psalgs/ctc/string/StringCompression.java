/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

/**
 *
 * @author djoshi
 *
 * Implement a method to perform basic string compression using the counts of
 * repeated characters.
 *
 * https://www.geeksforgeeks.org/run-length-encoding/
 *
 * Run Length Encoding
 * 
 * Time Complexity O(n)
 *
 */
public class StringCompression {

    private static void printRLE(String s) {
        int len = s.length();
        String temp = "";

        for (int i = 0; i < len; i++) {
            int count = 1;
            while (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            temp += s.charAt(i) + String.valueOf(count);
        }
        System.out.println(temp);
    }

    public static void main(String args[]) {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str); // w4a3d1e1x6y1w3
    }
}

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
 * http://www.geeksforgeeks.org/number-of-even-substrings-in-a-string-of-digits/
 *
 * Number of even substrings in a string of digits
 *
 */
public class EvenDigitString {

    private static int evenNumSubstring(char[] str) {
        int len = str.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            int temp = str[i] - '0';
            // If current digit is even, add count of substrings ending with it
            if (temp % 2 == 0) {
                count += (i + 1);
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String str = "1234";
        System.out.println(evenNumSubstring(str.toCharArray()));
    }
}

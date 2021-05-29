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
 * http://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/
 *
 * Given a binary string, count number of substrings that start and end with 1
 *
 * Time Complexity O(n)
 */
public class CountSubString {

    private int countSubStr(char str[], int n) {

        // Count of 1's in input string
        int m = 0;

        // pick a starting point
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '1') {
                m++;
            }
        }
        // Return count of possible pairs among m 1's
        return m * (m - 1) / 2;
    }

    public static void main(String[] args) {
        CountSubString count = new CountSubString();
        String string = "00100101";
        char str[] = string.toCharArray();
        int n = str.length;
        System.out.println(count.countSubStr(str, n));
    }
}

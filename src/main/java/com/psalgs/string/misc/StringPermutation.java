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
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 * Write a program to print all permutations of a given string ( back tracking)
 *
 * Time Complexity O(n ^ n!)
 *
 */
public class StringPermutation {

    private void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i); // exchange the chars
                permute(str, start + 1, end);  
                str = swap(str, start, i); // reset back the chars to original postion
            }
        }
    }

    private String swap(String a, int i, int j) {
        char[] charStr = a.toCharArray();
        char temp = charStr[i];
        charStr[i] = charStr[j];
        charStr[j] = temp;
        return String.valueOf(charStr);
    }

    public static void main(String args[]) {
        String str = "ABC";
        int n = str.length();
        StringPermutation p = new StringPermutation();
        p.permute(str, 0, n - 1);
    }
}

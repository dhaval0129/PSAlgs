/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.backtracking;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 * Write a program to print all permutations of a given string
 *
 * Time Complexity O(n ^ 2 * n!)
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
                str = swap(str, start, i); // reset back the chars to original position
            }
        }
    }

    private String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String args[]) {
        String str = "ABC";
        int n = str.length();
        StringPermutation p = new StringPermutation();
        p.permute(str, 0, n - 1);
    }
}

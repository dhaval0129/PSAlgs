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
 * http://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 *
 * https://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/
 *
 * Print Concatenation of Zig-Zag String in ‘n’ Rows
 */
public class PrintZigZag {

    private static String printZigZagConcat(String str, int n) {
        if (n == 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        // step
        int step = 2 * n - 2;

        for (int i = 0; i < n; i++) {
            //first & last rows
            if (i == 0 || i == n - 1) {
                for (int j = i; j < str.length(); j = j + step) {
                    sb.append(str.charAt(j));
                }
            } else { //middle rows	
                int j = i;
                boolean flag = true;
                int step1 = 2 * (n - 1 - i);
                int step2 = step - step1;

                while (j < str.length()) {
                    sb.append(str.charAt(j));
                    if (flag) {
                        j = j + step1;
                    } else {
                        j = j + step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
//        String str = "ABCDEFGH";
//        int n = 2;
        String str = "GEEKSFORGEEKS";
        int n = 3;
        System.out.println(printZigZagConcat(str, n));
    }
}

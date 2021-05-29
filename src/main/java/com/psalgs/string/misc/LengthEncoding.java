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
 * http://www.geeksforgeeks.org/run-length-encoding/
 *
 * Run Length Encoding
 *
 * Time Complexity O(n)
 *
 */
public class LengthEncoding {

    private static String encode(String str) {
        int len = str.length();
        String s = "";

        for (int i = 0; i < len; i++) {
            char curr = str.charAt(i);
            int count = 1;
            while (i < len - 1 && curr == str.charAt(i + 1)) {
                count++;
                i++;
            }
            s += curr + "" + count;
        }
        return s;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        System.out.println(encode(str));
    }
}

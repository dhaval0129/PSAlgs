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
 * http://www.geeksforgeeks.org/efficient-method-2s-complement-binary-string/
 *
 * Efficient method for 2’s complement of a binary string
 *
 */
public class TwosComplement {

    private static String findTwoscomplement(StringBuffer str) {
        int n = str.length();

        // Traverse the string to get first '1' from the last string
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                break;
            }
        }

        // If there exists no '1' concat 1 at the starting of string
        if (i == 0) {
            return "1" + str;
        }

        // Continue traversal after the position of first '1'
        for (int k = i - 1; k >= 0; k--) {
            //just flip the values
            if (str.charAt(k) == '1') {
                str.replace(k, k + 1, "0");
            } else {
                str.replace(k, k + 1, "1");
            }
        }
        
        return str.toString();
    }

    public static void main(String args[]) {
        StringBuffer str = new StringBuffer("00000101");
        System.out.println(findTwoscomplement(str));
    }
}

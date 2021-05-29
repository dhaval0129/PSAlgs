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
 * http://www.geeksforgeeks.org/binary-representation-of-next-number/
 *
 * Binary representation of next number
 *
 */
public class NextNumber {

    private static String nextGreater(String num) {
        int l = num.length();
        StringBuilder sb = new StringBuilder(num);

        for (int j = l - 1; j >= 0; j--) {

            if (sb.charAt(j) == '0') {
                sb.replace(j, j + 1, "1");
                break;
            } else {
                sb.replace(j, j + 1, "0");
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String num = "10011";
        System.out.println("Binary Representation of next number: " + nextGreater(num));
    }
}

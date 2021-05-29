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
 * http://www.geeksforgeeks.org/divide-a-string-in-n-equal-parts/
 *
 * Divide a string in N equal parts
 *
 */
public class StringDivide {

    private static void divideString(String str, int div) {
        int len = str.length();

        if (len % div != 0) {
            System.out.println("String cannot be divided in equal parts");
        }

        int size = len / div;

        for (int i = 0; i < len; i++) {
            if (i % size == 0) {
                System.out.println();
            }
            System.out.print(str.charAt(i));
        }
    }

    public static void main(String args[]) {
        String str = "a_simple_divide_string_quest";
        /*Print 4 equal parts of the string */
        divideString(str, 4);
    }
}

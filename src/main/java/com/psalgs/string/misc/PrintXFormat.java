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
 * http://www.geeksforgeeks.org/print-string-of-odd-length-in-x-format/
 *
 * Print string of odd length in ‘X’ format
 *
 */
public class PrintXFormat {

    private static void printXFormat(String str) {
        int n = str.length();
        int x = 0;
        int y = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == x) {
                    System.out.print(str.charAt(x));
                } else if (j == y) {
                    System.out.print(str.charAt(y));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            x++;
            y--;
        }
    }

    public static void main(String args[]) {
//        String str = "12345";
        String str = "geeksforgeeks";
        printXFormat(str);
    }
}

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
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 *
 * Print all possible strings that can be made by placing spaces
 * 
 * Time Complexity: O(n*(2^n))
 */
public class StringSpaces {

    private static void printPatternUtil(String str, char buf[], int i, int j, int n) {
        if (i == n) {
            buf[j] = '\0';
            System.out.println(buf);
            return;
        }

        //Either put the character
        buf[j] = str.charAt(i);
        printPatternUtil(str, buf, i + 1, j + 1, n);

        // Or put a space followed by next character
        buf[j] = ' ';
        buf[j + 1] = str.charAt(i);
        printPatternUtil(str, buf, i + 1, j + 2, n);
    }

    private static void printPattern(String str) {
        int len = str.length();
        // Buffer to hold the string containing spaces
        // 2n-1 characters and 1 string terminator
        char[] buf = new char[2 * len];
        // Copy the first character as it is, since it will be always at first position
        buf[0] = str.charAt(0);
        printPatternUtil(str, buf, 1, 1, len);
    }

    public static void main(String args[]) {
        String str = "ABCD";
        printPattern(str);
    }
}

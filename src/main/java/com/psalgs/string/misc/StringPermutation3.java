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
 * http://www.geeksforgeeks.org/print-ways-break-string-bracket-form/
 *
 * Print all ways to break a string in bracket form
 *
 */
public class StringPermutation3 {

    private static void findCombinations(String str, int index, String out) {
        if (index == str.length()) {
            System.out.println(out);
        }

        for (int i = index; i < str.length(); i++) {
            // Append substring formed by str[index,i] to output string
            findCombinations(str, i + 1, out + "(" + str.substring(index, i + 1) + ")");
        }
    }

    public static void main(String args[]) {
        String str = "abcd";
        findCombinations(str, 0, "");
    }
}

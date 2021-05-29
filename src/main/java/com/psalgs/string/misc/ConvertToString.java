/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/combinations-strings-can-used-dial-given-phone-number/
 *
 * All combinations of strings that can be used to dial a number
 */
public class ConvertToString {

    private static void printStrings(String phNo, int i,
            HashMap<Character, String> hm, StringBuilder sb) {

        // If all digits are processed, print output string
        if (i == phNo.length()) {
            System.out.print(sb + " ");
            return;
        }

        // Get current digit of phNo, and recur for all
        // characters that can be used to dial it.
        String s = hm.get(phNo.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            printStrings(phNo, i + 1, hm, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void printStringForNumber(String phNo) {
        HashMap<Character, String> hm = new HashMap<>();
        // For every digit, store characters that can be used to dial it.
        hm.put('2', "ABC");
        hm.put('3', "DEF");
        hm.put('4', "GHI");
        hm.put('5', "JKL");
        hm.put('6', "MNO");
        hm.put('7', "PQRS");
        hm.put('8', "TUV");
        hm.put('9', "WXYZ");
        hm.put('1', "1");
        hm.put('0', "0");

        // Create a string to store a particular output string
        StringBuilder sb = new StringBuilder();

        // Call recursive function
        printStrings(phNo, 0, hm, sb);
    }

    public static void main(String args[]) {
        printStringForNumber("23");
    }
}

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
 * http://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 * 
 * Print all the duplicates in the input string
 * 
 */
public class PrintDuplicates {

    private static final int chars = 26;

    private static void printDups(String str) {
        int[] alphabet = new int[chars];
        int len = str.length();

        for (int i = 0; i < len; i++) {
            alphabet[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < chars; i++) {
            if (alphabet[i] > 1) {
                char c = (char) (i + 'a');
                System.out.println("Character: " + c + " is " + alphabet[i]);
            }
        }
    }

    public static void main(String[] args) {
        String str = "test string";
        // Remove whitespace space
        str = str.replaceAll("\\s","");
        printDups(str);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 *
 * Return maximum occurring character in an input string
 *
 */
public class MaxCharacter {

    static final int ASCII_SIZE = 256;

    private static char getMaxOccurringChar(String str) {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input string
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if(max < count[i]){
                max = count[i];
                result = str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String str = "sample string";
        System.out.println("Max occurring character: " + getMaxOccurringChar(str));
    }
}

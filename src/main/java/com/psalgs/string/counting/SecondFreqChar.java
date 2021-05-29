/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/c-program-find-second-frequent-character/
 *
 * Program to find second most frequent character
 *
 * Time Complexity: O(n)
 */
public class SecondFreqChar {

    static final int NO_OF_CHARS = 128;

    private static char getSecondMostFreq(String str) {
        //count number of occurrences of every character. 
        int[] count = new int[NO_OF_CHARS];

        for (int i = 0; i < str.length(); i++) {
            (count[str.charAt(i)])++;
        }

        int first = 0;
        int second = 0;

        for (int i = 0; i < NO_OF_CHARS; i++) {
            // If current element is greater then 
            // first then update both first and second
            if (count[i] > count[first]) {
                second = first;
                first = i;
            } else if (count[i] > count[second] && count[i] != count[first]) {
                /* If count[i] is in between first and second then update second 
                   and count[i] is not same as first */
                second = i;
            }
        }
        return (char) second;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        char res = getSecondMostFreq(str);

        if (res != '\0') {
            System.out.println("Second most frequent char: " + res);
        } else {
            System.out.println("No second most frequent character");
        }
    }
}

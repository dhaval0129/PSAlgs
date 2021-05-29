/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 */
public class CountVowel {

    private static boolean isVowel(char c) {

        if (c == 'A' || c == 'E' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    private static int countVowels(String str) {
        int len = str.length();
        int result = 0;
        str = str.toUpperCase();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isVowel(c)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        //string object
        String str = "abc de";

        // Total numbers of Vowel
        System.out.println(countVowels(str));
    }

}

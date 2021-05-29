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
 * http://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
 *
 * Find kth character of decrypted string ( 'ab2cd2' and k=4 , so output will be
 * 'b' )
 */
public class kDecryptedString {

    private static char encodedChar(String str, int k) {
        String expand = "";
        String temp = "";
        int freq = 0;

        for (int i = 0; i < str.length();) {
            temp = "";
            freq = 0;

            // read characters until you find a number
            // or end of string
            while (i < str.length() && str.charAt(i) >= 'a'
                    && str.charAt(i) <= 'z') {
                // push character in temp
                temp += str.charAt(i);
                i++;
            }

            // read number for how many times string temp
            // will be repeated in decompressed string
            while (i < str.length() && str.charAt(i) >= '1'
                    && str.charAt(i) <= '9') {
                // generating frequency of temp
                freq = freq * 10 + str.charAt(i) - '0';
                i++;
            }

            // now append string temp into expand
            // equal to its frequency
            for (int j = 1; j <= freq; j++) {
                expand += temp;
            }
        }

        // this condition is to handle the case
        // when string str is ended with alphabets
        // not with numeric value
        if (freq == 0) {
            expand += temp;
        }

        return expand.charAt(k - 1);
    }

    public static void main(String args[]) {
        String str = "ab4c12ed3";
        int k = 21;
        System.out.println(encodedChar(str, k));
    }
}

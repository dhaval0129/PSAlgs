/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
 *
 * Number of flips to make binary string alternate
 *
 */
public class AlternateFlips {

    private static char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }

    private static int getFlipWithStartingCharacter(String str, char expected) {
        int flipcount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(c != expected) {
                flipcount++;
            }
            
            expected = flip(expected);
        }
        return flipcount;
    }

    private static int minFlipToMakeStringAlternate(String str) {
        //  return minimum of following two
        //  1) flips when alternate strign starts with 0
        //  2) flips when alternate strign starts with 1
        return Math.min(getFlipWithStartingCharacter(str, '0'),
                getFlipWithStartingCharacter(str, '1'));
    }

    public static void main(String args[]) {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }

}

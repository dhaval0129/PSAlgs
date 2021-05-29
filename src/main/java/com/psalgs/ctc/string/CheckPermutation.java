/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

/**
 *
 * @author djoshi
 *
 * Given two strings, write a method to decide if one is a permutation of the
 * other
 *
 * https://algorithms.tutorialhorizon.com/find-whether-two-strings-are-permutation-of-each-other/
 * 
 */
public class CheckPermutation {

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charCount = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String s1 = "abcd";
        String s2 = "dcba";
        
        boolean result = isPermutation(s1, s2);        
        System.out.println("Is Permutation: " + result);

    }
}

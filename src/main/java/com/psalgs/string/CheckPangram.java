/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/pangram-checking/
 *
 * Check if String is Pangram or not
 *
 * A Pangram is a sentence containing every letter in the English Alphabet.
 * 
 * 1] Remove white spaces from string and convert string alphabets to lowercase.
 * 
 * 2] Add string characters to Hashset
 * 
 * 3] If size of Hashset is less then 25 then string is not pangram otherwise it is pangram
 *
 */
public class CheckPangram {

    private static boolean checkPangram(String s) {
        Set<Character> alphabet = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            alphabet.add(s.charAt(i));
        }

        if (alphabet.size() < 26) {
            return false;
        }

        return true;
    }

    public static void main(String args[]) {
        String str = "The quick brown fox jumps over the lazy dog";
        String s = str.replaceAll("\\s", "").toLowerCase();

        if (checkPangram(s)) {
            System.out.println("String is pangram");
        } else {
            System.out.println("String is not pangram");
        }
    }
}

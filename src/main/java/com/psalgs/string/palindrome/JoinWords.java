/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.palindrome;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
 *
 * Palindrome pair in an array of words (or strings)
 *
 * It can be done more efficiently with Trie data structure ( will come back to
 * this later )
 *
 */
public class JoinWords {

    private static boolean isPalindrome(String str) {
        int len = str.length();

        for (int i = 0; i < (len / 2); i++) {
            if (str.charAt(i) == str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindromePair(List<String> vect) {

        // Consider each pair one by one        
        for (int i = 0; i < vect.size() - 1; i++) {
            for (int j = i + 1; j < vect.size(); j++) {
                String check_str = "";

                // concatenate both strings
                check_str = check_str + vect.get(i) + vect.get(j);

                // check if the concatenated string is
                // palindrome
                if (isPalindrome(check_str)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        List<String> vect = Arrays.asList("geekf", "geeks", "or",
                "keeg", "abc", "bc");

        if (checkPalindromePair(vect)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

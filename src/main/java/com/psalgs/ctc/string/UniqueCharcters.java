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
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * https://www.geeksforgeeks.org/determine-string-unique-characters/
 *
 * Time Complexity: O(n)
 */
public class UniqueCharcters {

    private boolean uniqueCharacters(String str) {
        // Assuming string can have characters a-z 
        // this has 32 bits set to 0 
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';

            // if that bit is already set in checker, 
            // return false 
            if ((checker & (1 << bitAtIndex)) > 0) {
                return false;
            }

            // otherwise update and continue by 
            // setting that bit in the checker 
            checker = checker | (1 << bitAtIndex);
        }

        // no duplicates encountered, return true 
        return true;
    }

    public static void main(String args[]) {
        UniqueCharcters obj = new UniqueCharcters();
        String input = "geeks";

        if (obj.uniqueCharacters(input)) {
            System.out.println("The String " + input + " has all unique characters");
        } else {
            System.out.println("The String " + input + " has duplicate characters");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.palindrome;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/nth-even-length-palindrome/
 *
 * Nth Even length Palindrome
 *
 */
public class EvenLength {

    private static String evenLength(String n) {
        // string r to store resultant palindrome. 
        // Initialize same as s
        String res = n;

        for (int i = n.length() - 1; i >= 0; i--) {
            res += res.charAt(i);
        }
        return res;
    }

    public static void main(String args[]) {
        String n = "101";
        System.out.println("Palindrome: "+evenLength(n));
    }
}

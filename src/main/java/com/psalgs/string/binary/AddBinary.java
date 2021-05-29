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
 * http://www.geeksforgeeks.org/program-to-add-two-binary-strings/
 *
 * Program to add two binary strings
 */
public class AddBinary {

    private static String addBinary(String a, String b) {
        String result = ""; // Initialize result
        int sum = 0;        // Initialize digit sum

        // Traverse both strings staring from last characters
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || sum == 1) {
            // compute sum of last digits and carry
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);
            
            // If current digits sum is 1 or 3, add 1 to result
            result = (char) (sum % 2 + '0') + result;
            
            // compute carry
            sum /= 2; 
            
            // Move to next digits
            i--; 
            j--;
        }

        return result;
    }

    public static void main(String args[]) {
        String a = "1101", b = "100";
        System.out.println(addBinary(a, b));

    }
}

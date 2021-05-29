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
 * http://www.geeksforgeeks.org/change-bits-can-made-one-flip/
 *
 * Change if all bits can be made same by single flip
 *
 */
public class SingleFlip {

    private static boolean canMakeAllSame(String s) {
        int len = s.length();
        int sum = 0;
        
        for(int i = 0; i < len; i++) {
            int x = s.charAt(i) - '0';
            sum += x;
        }
        
        // Return true if any of the two counts is 1
        return (sum == len - 1 || sum == 1);
    }
    
    public static void main(String args[]) {
        System.out.println(canMakeAllSame("101111111111") ? "Yes" : "No");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

/**
 *
 * Check if String is palindrome or not 
 * 
 * @author djoshi
 */
public class CheckPalindrome {
   
    public static boolean checkPalindrome(String s) {
        int n = s.length();
        
        for(int i=0; i<(n/2); i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(n-i-1);
            
            if( c1 != c2) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        String s = "acbaa";
        System.out.println("Is Palindrome: "+checkPalindrome(s));
    }
    
}

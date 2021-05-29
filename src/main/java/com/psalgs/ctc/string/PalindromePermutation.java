/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

import java.util.HashMap;

/**
 *
 * @author djoshi
 * 
 * https://leetcode.com/articles/palindrome-permutation/#
 * 
 * Given a string, write a function to check if it is a permutation of a palindrome
 * 
 */
public class PalindromePermutation {
  
    private static boolean isPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i < s.length(); i++) {
            
            if(map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            }
        }
       
        int c = 0;
        for(char key: map.keySet()) {
            int c1 = map.get(key);
            c += c1 % 2;
        }
        
        return c <= 1;
    }
    
    public static void main(String args[]) {
        String str = "racecar";
        System.out.println("Is Palindromic Permutation possible: " + isPalindrome(str));     
    }
}

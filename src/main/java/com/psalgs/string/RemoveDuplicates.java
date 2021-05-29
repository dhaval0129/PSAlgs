/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

import java.util.HashSet;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
 *
 * Remove all duplicates from a given string
 *
 * Method 1: Convert string to char array, sort string and remove duplicates.
 * 
 * Time Complexity: O (nlogn) + O(n) ( based on sorting algorithm )
 * 
 * Method 2: Convert string to char array, add string to HashSet. 
 * 
 * Time Complexity: O(n)
 */
public class RemoveDuplicates {

    private void removeDuplicates(String str) {
        char[] s = str.toCharArray();
        HashSet hs = new HashSet();

        for (int i = 0; i < s.length; i++) {
            hs.add(s[i]);
        }
        
        System.out.println(hs);
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        RemoveDuplicates r = new RemoveDuplicates();
        r.removeDuplicates(str);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author djoshi
 */
public class TwoCharacter {
    
    public static void main(String args[]) {
        String s = "beabeefeab";
        int[] alphabet = new int[26];
        char[] ch1 = s.toCharArray();
        List ls = new ArrayList<>();        
        ls = Arrays.asList(ch1);
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int x = ch - 'a';
            alphabet[x]++;
        }
    }
    
}

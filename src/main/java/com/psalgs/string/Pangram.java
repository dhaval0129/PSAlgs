/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

import java.util.StringTokenizer;

/**
 * Check if String is pangram or not 
 * 
 * pangram means = a sentence or verse that contains all the letters of the alphabet.
 * 
 * @author djoshi
 */
public class Pangram {
     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String s = "We promptly judged antique ivory buckles for the next prize";
        StringTokenizer st = new StringTokenizer(s.toLowerCase());
        
        boolean alphabet[] = new boolean[26];
        boolean pangram = true;
        
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
                //System.out.println(token);
                for(int i=0; i<token.length(); i++) {
                    int x = token.charAt(i) - 'a';   
                    //System.out.println(x);
                    alphabet[x] = true;     
                }
        }
        
        for(boolean b: alphabet) {
            if(b == false)
                pangram = false;
        }

        if(pangram) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

/**
 * Cipher the program with different ascii values
 * 
 * @author djoshi
 */
public class Cipher {

    public static void main(String[] args) {
        String s = "www.abc.xy";
        int k = 87;
        String output = "";
        
        if( k > 26) {
            k = k%26;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = (int) c;
                 
            if (x >= 65 && x <= 90) {
                int y = x + k;
                if (y > 90) {
                    int d = (y - 90) + 64;
                    y = d;
                }
                output += (char) y;
            } else if (x >= 97 && x <= 122) {
                int y = x + k;
                int d = 0;
                if (y > 122) {
                    d = (y - 122) + 96;
                    y = d;
                }
                output += (char) y;
            } else {
                output += c;
            }
        }    
        System.out.println(output);
    }
}

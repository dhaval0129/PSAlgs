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
 * http://www.geeksforgeeks.org/min-flips-of-continuous-characters-to-make-all-characters-same-in-a-string/
 *
 * Min flips of continuous characters to make all characters same in a string
 *
 */
public class MinFlips {

    private static int findFlips(String str) {
        int n = str.length();
        int last = str.charAt(0);
        int res = 0;

        for (int i = 1; i < n; i++) {
            int curr = str.charAt(i);
            
            if (last != curr) {
                res++;
            }
            last = curr;
        }
        return (res / 2);
    }

    public static void main(String[] args) {
        String str = "00011110001110";
        System.out.println(findFlips(str));
    }
}

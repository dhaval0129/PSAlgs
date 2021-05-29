/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximum-consecutive-repeating-character-string/
 *
 * Maximum consecutive repeating character in string
 *
 */
public class MaxConsecutiveRepeat {

    private static char maxConsecRepeat(String str) {
        int n = str.length();
        int curr_count = 0;
        int max = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (i > n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                curr_count++;
            } else if (max < curr_count) {
                max = curr_count;
                index = i;
            }
        }
        
        return str.charAt(index);
    }

    public static void main(String args[]) {
        String str = "aaaabbaaccde";
        System.out.println(maxConsecRepeat(str));
    }
}

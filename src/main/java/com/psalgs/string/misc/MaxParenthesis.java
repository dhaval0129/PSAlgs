/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-maximum-depth-nested-parenthesis-string/
 *
 * Find maximum depth of nested parenthesis in a string
 *
 * Time Complexity : O(n) 
 * Auxiliary Space : O(1)
 */
public class MaxParenthesis {

    private static int maxDepth(String str) {
        int n = str.length();
        int current_max = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                current_max++;
                if (current_max > max) {
                    max = current_max;
                }
            } else if (str.charAt(i) == ')') {
                if (current_max > 0) {
                    current_max--;
                } else {
                    return -1;
                }
            }
        }
        // finally check for unbalanced string
        if (current_max != 0) {
            return -1;
        }
        return max;
    }

    public static void main(String args[]) {
        String s = "( ((X)) (((Y))) )";
        System.out.println(maxDepth(s));
    }
}

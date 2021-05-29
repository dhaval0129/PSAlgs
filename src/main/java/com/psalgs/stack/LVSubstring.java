/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 *
 * Length of the longest valid substring
 *
 */
public class LVSubstring {

    private static int findMaxLen(String str) {
        int n = str.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // Initialize result
        int result = 0;

        // Traverse all characters of given string
        for (int i = 0; i < n; i++) {
            // If opening bracket, push index of it
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                // Pop the previous opening bracket's index
                stack.pop();

                // Check if this length formed with base of
                // current valid substring is more than max 
                // so far
                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    // If stack is empty. push current index as 
                    // base for next valid substring (if any)
                    stack.push(i);
                }
            }
        }

        return result;
    }

    // Driver method
    public static void main(String[] args) {
        String str = "((()()";
        System.out.println(findMaxLen(str));

        str = "()(()))))";
        System.out.println(findMaxLen(str));

    }
}

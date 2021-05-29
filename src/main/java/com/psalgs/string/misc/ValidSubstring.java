/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

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
public class ValidSubstring {

    private static int findMaxLen(String str) {
        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push("(");
            } else if (str.charAt(i) == ')') {
                String c = stack.pop();
                if (c.equals("(")) {
                    count += 2;
                }

                if (stack.isEmpty()) {
                    stack.push(")");
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "((()()";
        System.out.println(findMaxLen(str));

        str = "()(()))))";
        System.out.println(findMaxLen(str));

    }
}

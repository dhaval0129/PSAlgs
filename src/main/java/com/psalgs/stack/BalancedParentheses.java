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
 * http://www.geeksforgeeks.org/?p=6547
 *
 * Check for balanced parentheses in an expression
 *
 * Time Complexity O(n)
 *
 */
public class BalancedParentheses {

    private static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')' ) {
            return true;
        } else if (character1 == '{' && character2 == '}') {
            return true;
        } else if (character1 == '[' && character2 == ']') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean areParenthesisBalanced(char[] exp) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length; i++) {
            char c = exp[i];

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } 
                char x = stack.pop();
                if ( !isMatchingPair(x, c) ) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
            /*balanced*/
        } else {
            /*not balanced*/
            return false;
        }
    }

    public static void main(String args[]) {
        char exp[] = {'{', '(', ')', '}', '[', ']'};
        if (areParenthesisBalanced(exp)) {
            System.out.println("Balanced ");
        } else {
            System.out.println("Not Balanced ");
        }
    }
}

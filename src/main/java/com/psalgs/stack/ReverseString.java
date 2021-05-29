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
 * http://www.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
 * 
 * Reverse the String
 */
public class ReverseString {

    private static String reverse(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            stack.push(c);
        }

        String result = new String("");

        for (int i = 0; i < len; i++) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String args[]) {
        //create a new string
        String s = new String("GeeksforGeeks");
        //call reverse method
        reverse(s);
        //print the reversed string
        System.out.println("Reversed string is : " + s);
    }

}

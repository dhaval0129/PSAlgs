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
 * http://www.geeksforgeeks.org/?p=6921
 *
 * Reverse a stack using recursion
 *
 */
public class ReverseStack {

    //using Stack class for stack implementation
    static Stack<Character> stack = new Stack<>();

    private static void insert_at_bottom(char x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            /* All items are held in Function Call Stack until we
               reach end of the stack. When the stack becomes
               empty, the st.size() becomes 0, the
               above if part is executed and the item is inserted
               at the bottom */
            char a = stack.peek();
            stack.pop();
            insert_at_bottom(x);
            stack.push(a);
        }
    }

    private static void reverse() {
        if (stack.size() > 0) {
            char x = stack.pop();
            reverse();
            insert_at_bottom(x);
        }
    }

    public static void main(String[] args) {
        //push elements into the stack
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');

        System.out.println("Original Stack");
        System.out.println(stack);
        //function to reverse the stack
        reverse();
        System.out.println("Reversed Stack");
        System.out.println(stack);
    }

}

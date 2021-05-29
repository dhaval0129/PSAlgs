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
 * http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 *
 * Stack Data structure to return minimum values in stack 
 * randomly during push and pop operation ( Space Optimized Version )
 *
 */
public class GetMinValue extends Stack<Integer> {

    Stack<Integer> min = new Stack<>();

    private void push(int x) {
        if (isEmpty()) {
            super.push(x);
            min.push(x);
        } else {
            super.push(x);
            int y = min.peek();
            if (x <= y) {
                min.push(x);
            }
        }
    }

    @Override
    public Integer pop() {
        int x = super.pop();
        int y = min.peek();

        if (y == x) {
            min.pop();
        }
        return x;
    }

    private int getMin() {
        return min.peek();
    }

    public static void main(String args[]) {
        GetMinValue s = new GetMinValue();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(4);
        s.push(12);
        System.out.println(s.getMin());
        s.push(2);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.getMin());
    }
}

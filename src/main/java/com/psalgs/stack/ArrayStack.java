/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 *
 * Array based stack
 */
public class ArrayStack {

    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of stack

    private ArrayStack() {
        top = -1;
    }

    private boolean isEmpty() {
        return (top < 0);
    }

    private boolean push(int x) {
        if (top >= MAX) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            return true;
        }
    }

    private int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    public static void main(String args[]) {
        ArrayStack s = new ArrayStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}

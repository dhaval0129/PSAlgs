/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.stack;

import java.util.Stack;

/**
 *
 * @author djoshi
 */
class StackMin extends Stack<Integer> {

    Stack<Integer> stackMin;

    StackMin() {
        stackMin = new Stack<Integer>();
    }

    void push(int value) {
        if (value <= min()) {
            stackMin.push(value);
        }
        super.push(value);
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            stackMin.pop();
        }
        return value;
    }

    int min() {
        if (stackMin.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stackMin.peek();
    }

    private void print() {
        System.out.println("Min Stack: " + stackMin);
        System.out.println("Stack Content: " + super.toString());
    }

    public static void main(String args[]) {
        StackMin sm = new StackMin();
        sm.push(5);
        sm.push(6);
        sm.push(3);
        sm.push(7);
        sm.pop();
        sm.pop();

        sm.print();
    }
}

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
 *
 * Sort a stack such that the smallest items are on the top.
 *
 * https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
 *
 */
public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> input) {

        Stack<Integer> tmpStack = new Stack<Integer>();

        while (!input.isEmpty()) {
            int tmp = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }

            tmpStack.push(tmp);
        }

        return tmpStack;
    }

    public static void main(String args[]) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack 
        Stack<Integer> tmpStack = sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty()) {
            System.out.print(tmpStack.pop() + " ");
        }
    }
}

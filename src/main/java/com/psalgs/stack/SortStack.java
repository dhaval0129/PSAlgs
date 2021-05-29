/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 *
 * Sort a stack using recursion
 *
 */
public class SortStack {

    private static void sortedInsert(Stack<Integer> s, int x) {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);
        // Put back the top item removed earlier
        s.push(temp);
    }

    private static void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();
            // Sort remaining stack
            sortStack(s);
            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

    // Utility Method to print contents of stack
    private static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext()) {
            lt.next();
        }

        // printing from top to bottom
        while (lt.hasPrevious()) {
            System.out.print(lt.previous() + " ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
        System.out.println();
    }
}

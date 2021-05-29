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
 * http://www.geeksforgeeks.org/?p=18754
 *
 * Implement two stacks in an array
 *
 */
public class TwoStacks {

    int size;
    int top1, top2;
    int arr[];

    private TwoStacks(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = n;
    }

    private void push1(int n) {

        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = n;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    private void push2(int n) {

        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = n;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    private int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack underflow");
            System.exit(1);
        }
        return 0;
    }

    private int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack underflow");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String args[]) {
        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is " + ts.pop2());
    }
}

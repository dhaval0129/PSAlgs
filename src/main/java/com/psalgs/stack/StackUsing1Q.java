/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
 *
 * Implement a stack using single queue
 *
 */
public class StackUsing1Q {

    Queue<Integer> q = new LinkedList<>();

    private void push(int value) {
        // get previous size of queue
        int size = q.size();
        // Add current element
        q.add(value);

        // Pop (or Dequeue) all previous
        // elements and put them after current
        // element
        for (int i = 0; i < size; i++) {
            int x = q.remove();
            q.add(x);
        }
    }

    private int pop() {
        if (q.isEmpty()) {
            System.out.println("No Elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    private int top() {
        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    private boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String args[]) {
        StackUsing1Q s = new StackUsing1Q();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.pop();
        s.push(50);
        s.pop();
        System.out.println("Top element :" + s.top());
    }

}

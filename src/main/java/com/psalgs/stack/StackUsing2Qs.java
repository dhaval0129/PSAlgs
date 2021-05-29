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
 * http://www.geeksforgeeks.org/implement-stack-using-queue/
 * 
 * https://stackoverflow.com/questions/688276/implement-stack-using-two-queues
 * 
 * Implement Stack using Queues ( using two queue's )
 * 
 */
public class StackUsing2Qs {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    private void push(int data) {
        if (q1.peek() == null) {
            q1.add(data);
        } else {
            for (int i = q1.size(); i > 0; i--) {
                q2.add(q1.remove());
            }
            q1.add(data);

            for (int i = q2.size(); i > 0; i--) {
                q1.add(q2.remove());
            }
        }
    }

    private int pop() {
        if (q1.peek() == null) {
            System.out.println("The stack is empty, nothing to return");
            return 0;
        } else {
            int pop = q1.remove();
            return pop;
        }
    }

    public static void main(String args[]) {
        StackUsing2Qs s1 = new StackUsing2Qs();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());
        System.out.println("4th = " + s1.pop());
        System.out.println("5th = " + s1.pop());
        System.out.println("6th = " + s1.pop());
        System.out.println("7th = " + s1.pop());
        System.out.println("8th = " + s1.pop());
        System.out.println("9th = " + s1.pop());
        System.out.println("10th= " + s1.pop());
    }
}

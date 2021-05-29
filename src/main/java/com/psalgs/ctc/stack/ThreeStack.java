/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.stack;

/**
 *
 * @author djoshi
 *
 * Describe how you could use a single array to implement three stacks
 *
 * https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 *
 */
public class ThreeStack {

    static class KStack {

        int arr[];
        int top[];
        int next[];

        int n, k;
        int free;

        KStack(int k1, int n1) {
            k = k1;
            n = n1;

            arr = new int[n];
            top = new int[k];
            next = new int[n];

            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }

            free = 0;
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1;
        }

        private boolean isFull() {
            return (free == -1);
        }

        private boolean isEmpty(int sn) {
            return (top[sn] == -1);
        }

        private void push(int item, int sn) {

            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            int i = free;

            // Update index of free slot to index of next slot in free list 
            free = next[i];

            // Update next of top and then top for stack number 'sn' 
            next[i] = top[sn];
            top[sn] = i;

            // Put the item in array 
            arr[i] = item;
        }

        private int pop(int sn) {

            if (isEmpty(sn)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            // Find index of top item in stack number 'sn' 
            int i = top[sn];

            top[sn] = next[i]; // Change top to store next of previous top 

            // Attach the previous top to the beginning of free list 
            next[i] = free;
            free = i;

            // Return the previous top item 
            return arr[i];
        }
    }

    public static void main(String args[]) {
        // Let us create 3 stacks in an array of size 10 
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1 
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0 
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}

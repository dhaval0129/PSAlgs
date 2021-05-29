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
 * http://www.geeksforgeeks.org/next-greater-element/
 *
 * Time Complexity O(n)
 */
public class NextGreaterElement {

    private static void printNGE(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        int element, next;

        s.push(arr[0]);

        for (int i = 1; i < n; i++) {
            next = arr[i];

            if (!s.isEmpty()) {
                element = s.pop();

                while (element < next) {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty()) {
                        break;
                    }
                    element = s.pop();
                }

                /* If element is greater than next, then 
                   push the element back */
                if (element > next) {
                    s.push(element);
                }
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }
        /* After iterating over the loop, the remaining 
           elements in stack do not have the next greater 
           element, so print -1 for them */
        while (!s.isEmpty()) {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    public static void main(String args[]) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
    }
}

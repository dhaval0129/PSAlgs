/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/next-greater-element/
 *
 * Next Greater Element ( Hint: Use stack )
 *
 * Time Complexity: O(n)
 */
public class NGE {

    private static void printNGE(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int element, next;

        s.push(arr[0]);

        for (int i = 1; i < n; i++) {
            next = arr[i];

            if (!s.isEmpty()) {
                element = s.pop();

                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty()) {
                        break;
                    }
                    element = s.pop();
                }

                if (element > next) {
                    s.push(element);
                }
            }

            s.push(next);
        }
    }

    public static void main(String args[]) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
    }
}

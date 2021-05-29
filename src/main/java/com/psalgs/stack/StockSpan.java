/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 *
 * The Stock Span Problem
 *
 * Time Complexity O(n)
 *
 */
public class StockSpan {

    private static void calculateSpan_Stack(int price[], int n, int S[]) {
        // Create a stack and push index of first element to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        for (int i = 1; i < n; i++) {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }

    }
    
    //  method to calculate stock span values
    private static void calculateSpan(int price[], int n, int S[])
    {
        // Span value of first day is always 1
        S[0] = 1;
         
        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++)
        {
            S[i] = 1; // Initialize span value
             
            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                S[i]++;
        }
    }

    private static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }
}

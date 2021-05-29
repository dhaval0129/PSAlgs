/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 *
 * Sliding Window Maximum (Maximum of all sub-arrays of size k)
 *
 * Time Complexity O(n)
 *
 */
public class MaxSubArray {

    private static void printKMax(int arr[], int n, int k) {

        Deque<Integer> Qi = new LinkedList<>();

        int i;
        for (i = 0; i < k; ++i) {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();   // Remove from rear
            }
            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) {
                Qi.removeFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()] + "\n");
    }

    public static void main(String args[]) {
        //int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printKMax(arr, arr.length, k);
    }

}

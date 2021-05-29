/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

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
 * Given an array and an integer k, find the maximum for each and every
 * contiguous sub-array of size k.
 *
 * Time Complexity O(n)
 *
 */
public class SlidingWindowMax {

    private static void printKMax(int[] arr, int n, int k) {
        // Create a Double Ended Queue, dq that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in dq,  
        // i.e. arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast(); // Remove from rear
            }
            // Add new element at rear of queue
            dq.addLast(i);
        }

        // Process rest of the elements, ie. from arr[k] to arr[n-1]
        for (int i = k; i < n; i++) {
            // The element at the front of the queue is largest element of previous windows
            System.out.print(arr[dq.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!dq.isEmpty()) && dq.peek() <= i - k) {
                dq.removeFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            // Add current element at rear of dq
            dq.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[dq.peek()]);
    }

    public static void main(String args[]) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int n = arr.length;
        int k = 3;
        printKMax(arr, n, k);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.sort;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 *
 * https://stackoverflow.com/questions/10008118/how-to-find-3-numbers-in-increasing-order-and-increasing-indices-in-an-array-in
 *
 * Find a sorted subsequence of size 3 in linear time
 *
 * Time Complexity: O(n) Auxiliary Space: O(n)
 *
 * Note: You can apply LIS algorithm but then time complexity would be either
 * O(n ^ 2) or O(n log n)
 */
public class SortedSubSeq {

    private static void find3Numbers(int[] arr) {
        int n = arr.length;
        int max = n - 1; // index of maximum element on right side
        int min = 0; // index of minimum element from left side

        // Create an array that will store index of a smaller
        // element on left side. If there is no smaller element
        // on left side, then smaller[i] will be -1
        int[] smaller = new int[n];
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                // update min pointer is current value is less then previous value
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        // Create another array that will store index of a
        // greater element on right side. If there is no greater
        // element on right side, then greater[i] will be -1
        int[] greater = new int[n];
        greater[n - 1] = -1; // last entry will always be -1
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                // update max pointer if current value is greater then next value
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        // Now find a number which has both a greater number
        // on right side and smaller number on left side
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.print(arr[smaller[i]] + " " + arr[i] + " " + arr[greater[i]]);
            }
        }

        // If we reach number, then there are no such 3 numbers
        System.out.println("No such triplet found");
        return;
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        find3Numbers(arr);
    }

}

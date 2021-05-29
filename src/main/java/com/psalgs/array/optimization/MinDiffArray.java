/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.optimization;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-minimum-difference-pair/
 *
 * Find minimum difference between any two elements
 *
 * Given an unsorted array, find the minimum difference between any pair in
 * given array.
 *
 * Time Complexity: O(n) + O(n*log n) 
 * Auxiliary Space: O(1)
 *
 */
public class MinDiffArray {

    private static int findMinDiff(int[] arr, int n) {
        // sort the array in O(n log n) time
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        // O(n)
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];

            if (minDiff > diff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String args[]) {
        int[] arr = {1, 5, 3, 19, 18, 25};
        int n = arr.length;

        System.out.println("Minimum difference is " + findMinDiff(arr, n));
    }
}

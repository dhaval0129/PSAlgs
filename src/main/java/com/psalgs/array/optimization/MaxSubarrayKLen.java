/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.optimization;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/
 *
 * Find maximum average sub-array of k length
 *
 */
public class MaxSubarrayKLen {

    private static int findMaxAverage(int[] arr, int n, int k) {
        // base case
        if (k > n) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max_sum = sum;
        int endIndex = k - 1;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (max_sum < sum) {
                max_sum = sum;
                endIndex = i;
            }
        }
        // we add +1 to ( endIndex -k ) get the start index
        return (endIndex - k + 1);
    }

    public static void main(String args[]) {
        int arr[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        int n = arr.length;

        System.out.println("The maximum average subarray of length " + k
                + " starts at index: " + findMaxAverage(arr, n, k));
    }
}

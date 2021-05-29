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
 * http://www.geeksforgeeks.org/find-subarray-least-average/
 *
 * Find the sub-array with least average
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class LeastAverage {

    private static void findMinAvgSubArray(int[] arr, int n, int k) {
        // k must be smaller than or equal to n
        if (n < k) {
            return;
        }

        // Initialize  beginning index of result
        int res_index = 0;

        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++) {
            curr_sum += arr[i];
        }

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;
        // Traverse from (k+1)'th element to nth element
        for (int i = k; i < n; i++) {

            //Add current item and remove first item of the previous result
            curr_sum += arr[i] - arr[i - k];

            // Update result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = (i - k + 1);
            }
        }

        System.out.println("Subarray between [" + res_index + ", "
                + (res_index + k - 1) + "] has minimum average");
    }

    public static void main(String args[]) {
        int arr[] = {3, 7, 90, 20, 10, 50, 40};
        int k = 3; // Subarray size
        findMinAvgSubArray(arr, arr.length, k);
    }
}

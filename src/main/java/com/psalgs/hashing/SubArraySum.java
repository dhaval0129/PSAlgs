/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 *
 * Find the largest subarray with 0 sum
 *
 * Time Complexity O(n ^ 2 )
 */
public class SubArraySum {

    private static int maxLen(int arr[], int n) {
        int max_len = 0;

        for (int i = 0; i < n; i++) {
            // Initialize curr_sum for every starting point
            int curr_sum = 0;

            for (int j = i; j < n; j++) {
                curr_sum += arr[j];

                if (curr_sum == 0) {
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }
        return max_len;
    }

    public static void main(String args[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = arr.length;
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr, n));
    }
}

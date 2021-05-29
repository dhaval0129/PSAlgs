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
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 *
 * Maximum Sum Increasing Subsequence
 *
 * Hint: problem is slight variation of LIS, instead of incrementing by 1, we
 * calculate sum and store maximum value after each level of iteration
 * 
 */
public class MaxSumIS {

    private static int maxSumIS(int[] arr, int n) {
        // copy the array values
        int[] msis = Arrays.copyOfRange(arr, 0, n);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }

            // find the max value
            if (max < msis[i]) {
                max = msis[i];
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing "
                + " subsequence is " + maxSumIS(arr, n));
    }
}

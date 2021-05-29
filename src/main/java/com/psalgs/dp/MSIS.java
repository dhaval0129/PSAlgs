/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 *
 * Java implementation of Maximum Sum of Increasing Subsequence (MSIS) problem
 *
 * example: { 1, 101, 2, 3, 100, 4, 5 } then output should be 106 (1 + 2 + 3 +
 * 100)
 */
public class MSIS {

    /* maxSumIS() returns the maximum sum of increasing
       subsequence in arr[] of size n */
    static int maxSumIS(int arr[], int n) {
        int msis[] = new int[n];

        /* Initialize msis values for all indexes */
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }

        /* Compute maximum sum values in bottom up manner */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    msis[i] = Math.max(msis[i], msis[i] + arr[j]);
                }
            }
        }

        int max = msis[0];
        for (int k = 1; k < msis.length; k++) {
            if (msis[k] > max) {
                max = msis[k];
            }
        }
        return max;

    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing subsequence is " + maxSumIS(arr, n));
    }

}

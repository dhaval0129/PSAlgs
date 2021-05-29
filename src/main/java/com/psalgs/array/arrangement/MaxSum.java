/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximize-sum-consecutive-differences-circular-array/
 *
 * Maximize sum of consecutive differences in a circular array
 *
 * Time Complexity: O(n log n) Auxiliary Space: O(1)
 *
 */
public class MaxSum {

    private static int maxSum(int[] arr, int n) {
        int sum = 0;
        // Sorting the array.
        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
        return sum;
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 1, 8};
        int n = arr.length;

        System.out.println(maxSum(arr, n));
    }
}

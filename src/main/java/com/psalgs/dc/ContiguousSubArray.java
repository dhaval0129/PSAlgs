/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
 *
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 * Maximum Sub-array Sum
 *
 * Note: Kadane's Algorithm is better then recursion, It solves the problem in
 * O(n) time
 *
 */
public class ContiguousSubArray {

    private static int maxCrossingSum(int[] arr, int l, int m, int h) {
        return 0;
    }

    private static int maxSubArraySum(int[] arr, int start, int end) {
        // base case
        if (start == end) {
            return arr[start];
        }

        int mid = (start + end) / 2;

        return Math.max(
                Math.max(maxSubArraySum(arr, start, mid), maxSubArraySum(arr, mid + 1, end)),
                maxCrossingSum(arr, start, mid, end));
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 5, 7};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is " + max_sum);
    }
}

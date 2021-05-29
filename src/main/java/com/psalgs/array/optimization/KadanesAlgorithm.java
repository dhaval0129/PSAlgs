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
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 * Largest Sum Contiguous Sub-array ( Kadane's Algorithm )
 *
 * Time Complexity: O(n)
 *
 * Hint:
 *
 * 1] keep track for total max value and current max value while adding array
 * values.
 *
 * 2] if current max is less then zero then reset it back to zero.
 *
 */
public class KadanesAlgorithm {

    private static int maxSubArraySum(int[] a) {
        int size = a.length;
        int max = Integer.MIN_VALUE;
        int curr_max = 0;

        for (int i = 0; i < size; i++) {
            curr_max += a[i];

            if (max < curr_max) {
                max = curr_max;
            }

            if (curr_max < 0) {
                curr_max = 0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

}

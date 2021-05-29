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
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 *
 * http://algorithms.tutorialhorizon.com/in-an-array-find-the-smallest-subarray-with-sum-greater-than-the-given-value/
 *
 * Smallest sub-array with sum greater than a given value
 *
 * Time Complexity O(n)
 *
 */
public class SubArrayKSum {

    // find sub array greater then or equal to given value
    private static void minSubArray(int[] arr, int k) {
        int n = arr.length;
        int start = 0;    // start counter for sub-array
        int ansEnd = 0;   // end index of answer
        int ansStart = 0; // start index of answer
        int currSum = 0;  // current sum so far
        int minLen = n;   // size of sub-array

        for (int i = 0; i <= n; i++) {

            // current sum is greater then given value
            while (currSum > k) {
                currSum -= arr[start];

                // condition to update the vars
                if (i - start <= minLen) {
                    minLen = (i - start); // lower the length
                    ansEnd = i;           // update end index of answer
                    ansStart = start;     // update start index of answer
                }
                // increment start since we deleted from currSum
                start++;
            }

            // add to currSum if not reached to given value
            if (i < n) {
                currSum += arr[i];
            }
        }

        System.out.println("Minimum length of subarray to get " + k + " is : " + minLen);
        System.out.print("SubArray is: " + Arrays.toString(Arrays.copyOfRange(arr, ansStart, ansEnd)));
    }

    public static void main(String args[]) {
        int[] arr = {1, 10, 3, 40, 18};
        minSubArray(arr, 50); 
    }
}

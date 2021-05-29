/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-strictly-increasing-subarrays/
 *
 * Count Strictly Increasing Sub-arrays ( array is sorted )
 *
 * (Generate all possible sub-arrays in increasing order)
 *
 * http://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
 *
 * Time Complexity: O(n) Auxiliary Space: O(1)
 *
 * Notes:
 *
 * An Efficient Solution can count sub-arrays in O(n) time. The idea is based on
 * fact that a sorted sub-array of length 'len' adds [ len *(len-1) /2 ] to
 * result. For example: {10, 20, 30, 40} adds 6 to the result.
 *
 */
public class IncreasingSubArrays {

    private static int countIncreasing(int[] arr, int n) {
        // Initialize count of subarrays as 0
        int cnt = 0;

        // Pick starting point
        for (int i = 0; i < n; i++) {
            // Pick ending point
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[j - 1]) {
                    cnt++;
                } else {
                    // If subarray arr[i..j] is not strictly increasing, then subarrays after it , i.e., 
                    // arr[i..j+1], arr[i..j+2], .... cannot be strictly increasing
                    break;
                }
            }
        }
        return cnt;
    }

    private static int countIncreasing_Optimized(int[] arr, int n) {
        int cnt = 0;  // Initialize result

        // Initialize length of current increasing subarray
        int len = 1;

        // Traverse through the array
        for (int i = 0; i < n - 1; i++) {
            // If arr[i+1] is greater than arr[i] than increment length
            if (arr[i + 1] > arr[i]) {
                len++;
            } else {
                // update count and reset length
                cnt += (((len - 1) * len) / 2);
                len = 1;
            }
        }

        // If last length is more than 1
        if (len > 1) {
            cnt += (((len - 1) * len) / 2);
        }

        return cnt;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 4}; // Array has to be in sorted order
        int n = arr.length;

        System.out.println("Count of strictly increasing subarrays is: "
                + countIncreasing_Optimized(arr, n));
    }
}

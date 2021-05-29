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
 * http://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
 *
 * Longest Span with same Sum in two Binary arrays
 *
 * Time Complexity O(n) 
 * Auxiliary Space O(2n + 1)
 *
 */
public class LongestSpanSum {

    private static int arr1[] = {0, 1, 0, 1, 1, 1, 1};
    private static int arr2[] = {1, 1, 1, 1, 1, 0, 1};

    private static int longestCommonSum(int n) {
        int maxLen = 0;

        // Initialize prefix sums of two arrays
        int preSum1 = 0, preSum2 = 0;

        // Create an array to store staring and ending
        // indexes of all possible diff values. diff[i]
        // would store starting and ending points for
        // difference "i-n"
        int diff[] = new int[2 * n + 1];

        // Initialize all starting and ending values as -1.
        Arrays.fill(diff, -1);

        // Traverse both arrays
        for (int i = 0; i < n; i++) {
            // Update prefix sums
            preSum1 += arr1[i];
            preSum2 += arr2[i];

            // Compute current diff and index to be used in diff array.
            // note that diff can be negative and can have minimum value as -1.
            int curr_diff = preSum1 - preSum2;
            int diffIndex = n + curr_diff;

            // If current diff is 0, then there are same number
            // of 1's so far in both arrays, i.e (i+1) is maximum length.
            if (curr_diff == 0) {
                maxLen = i + 1;
            } else if (diff[diffIndex] == -1) {
                //If index is seen first time, then update starting index of diff.
                diff[diffIndex] = i;
            } else {
                // Find length of this same sum common span
                int len = i - diff[diffIndex];

                // Update max len if needed
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }

    public static void main(String args[]) {
        int n = arr1.length;

        System.out.print("Length of the longest common span with same sum is ");
        System.out.println(longestCommonSum(n));
    }
}

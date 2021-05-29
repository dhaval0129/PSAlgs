/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 *
 * Largest sub array with equal number of 0s and 1s
 *
 * Time Complexity: O(n) Auxiliary Space: O(n)
 *
 */
public class LargestSubarray2 {

    private int maxLen(int[] arr, int n) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            // To handle sum = 0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            if (hM.containsKey(sum)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i = hM.get(sum + n);
                    ending_index = i;
                }
            } else {
                // else put this sum in hash tabl
                hM.put(sum + n, i);
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

    public static void main(String args[]) {
        LargestSubarray2 sub = new LargestSubarray2();
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int n = arr.length;

        sub.maxLen(arr, n);
    }

}

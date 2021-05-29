/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashSet;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 *
 * Length of the largest sub-array with contiguous elements
 *
 * Contiguous means numbers that can be arranged in continuous sequence
 *
 * Time Complexity: O(n^2)
 *
 */
public class LargestSubarray {

    private static int findLength(int[] arr) {
        int n = arr.length;
        int max_len = 1;

        for (int i = 0; i < n - 1; i++) {
            // Create an empty hash set and add i'th element to it
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);

            // Initialize max and min in current subarray
            int mn = arr[i], mx = arr[i];

            for (int j = i + 1; j < n; j++) {
                // If current element is already in hash set, then 
                // this subarray cannot contain contiguous elements
                if (set.contains(arr[j])) {
                    break;
                }

                // Else add curremt element to hash set and update
                // min, max if required.
                set.add(arr[j]);
                mn = Math.min(mn, arr[j]); // returns min
                mx = Math.max(mx, arr[j]); // returns max

                // We have already checked for the duplicates, now check 
                // for other property and update max_len if needed
                if (mx - mn == j - i) {
                    max_len = Math.max(max_len, mx - mn + 1);
                }
            }
        }
        return max_len;
    }

    public static void main(String args[]) {
        int arr[] = {10, 12, 12, 10, 10, 11, 10};
        System.out.println("Length of the longest contiguous subarray is "+ findLength(arr));
    }

}

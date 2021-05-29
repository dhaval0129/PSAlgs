/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 *
 * Largest sub-array with equal number of 0s and 1s
 *
 * Time Complexity: O(n) 
 * Auxiliary Space: O(n)
 *
 */
public class LargestSubArray {

    // O( n ^ 2)
    private static int findSubArray(int[] arr, int n) {
        int sum = 0;
        int max = -1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {
            sum = (arr[i] == 0) ? -1 : 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 0) {
                    sum += -1;
                } else {
                    sum += 1;
                }

                if (sum == 0 && max < j - i + 1) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        end = start + max - 1;

        if (max == -1) {
            System.out.println("No such subarray");
        } else {
            System.out.println(start + " to " + end);
        }

        return max;
    }

//    Time Complexity: O(n)
//    Auxiliary Space: O(n)
    private static void maxLen(int arr[], int n) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        // change all 0s to -1
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            // sum == 0 then update the len & end index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            // as it might contain sum zero in middle of sub-array
            if (hM.containsKey(sum)) {
                if (max_len < i - hM.get(sum)) {
                    max_len = i - hM.get(sum);
                    ending_index = i;
                }
            } else {
                hM.put(sum, i);
            }
        }

        // Return array back to orginal values
//        for (int i = 0; i < n; i++) {
//            arr[i] = (arr[i] == -1) ? 0 : 1;
//        }
        if (ending_index != -1) {
            start_index = ending_index - max_len + 1;
            System.out.println(start_index + " to " + ending_index);
        } else {
            System.out.println("No such sub-array");
        }

    }

    public static void main(String args[]) {
//        int arr[] = {1, 1, 1, 1, 0, 1, 1};
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int size = arr.length;

//        findSubArray(arr, size);
        maxLen(arr, size);
    }
}

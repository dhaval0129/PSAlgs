/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 *
 * Maximum Length Bitonic Subarray.
 *
 * Note: This problem is different from longest Bitonic subsequence. in
 * subsequence we try to find increasing combination of numbers in whole array.
 * and in sub-array we look for increasing and continuous number which can form
 * sub-array
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 *
 */
public class BitonicSubArray {

    private static int bitonic(int[] arr, int n) {
        int[] inc = new int[n]; // Length of increasing subarray ending at all indexes
        int[] dec = new int[n]; // Length of decreasing subarray starting at all indexes
        int max;

        // Length of increasing sequence ending at first index is 1
        inc[0] = 1;
        // Length of increasing sequence starting at first index is 1
        dec[n - 1] = 1;

        // Step 1) Construct increasing sequence array
        for (int i = 1; i < n; i++) {
            inc[i] = (arr[i] >= arr[i - 1]) ? inc[i - 1] + 1 : 1;
        }

        // Step 2) Construct decreasing sequence array
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = (arr[i] >= arr[i + 1]) ? dec[i + 1] + 1 : 1;
        }

        // Step 3) Find the length of maximum length bitonic sequence
        max = inc[0] + dec[0] - 1;
        for (int i = 1; i < n; i++) {
            if (inc[i] + dec[i] - 1 > max) {
                max = inc[i] + dec[i] - 1;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int arr[] = {12, 4, 78, 90, 45, 23};
        int n = arr.length;

        System.out.println("Length of max length Bitnoic Subarray is " + bitonic(arr, n));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.sort;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-whether-given-array-k-sorted-array-not/
 *
 * Check whether a given array is a k sorted array or not
 *
 * Time Complexity: O(n log n) Auxiliary space: O(n)
 *
 */
public class kSorted {

    private static boolean isKSortedArray(int[] arr, int n, int k) {
        int[] aux = new int[n];
        // sort array java uses quick sort for numbers
        Arrays.sort(aux);

        // for every element of 'arr' at index 'i', 
        // find its index 'j' in 'aux'
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(aux, arr[i]);

            // if abs(i-j) > k, then that element is
            // not at-most k distance away from its 
            // target position. Thus,  'arr' is not a 
            // k sorted array 
            if (Math.abs(i - j) > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("Is it a k sorted array ?: " + isKSortedArray(arr, arr.length, k));
    }
}

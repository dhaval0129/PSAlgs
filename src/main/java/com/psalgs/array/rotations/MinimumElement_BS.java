/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.rotations;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 *
 * Find the minimum element in a sorted and rotated array
 *
 * Time Complexity O(log n)
 */
public class MinimumElement_BS {

    // Hint: 
    // In this type of binary search condition checks should be done in opposite
    // of what we do in regular binary search except for low ,mid and high value condition checks
    private static int findMin(int[] arr, int low, int high) {
        if (low > high) {
            return arr[0];
        }

        if (low == high) {
            return arr[low];
        }

        int mid = low + (high - low) / 2;

        if (mid < high && arr[mid + 1] < arr[mid]) {
            return arr[mid + 1];
        }

        if (low < mid && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }

        // check if we need to go left half or right half
        if (arr[mid] > arr[high]) {
            return findMin(arr, mid + 1, high);
        }

        return findMin(arr, low, mid - 1);
    }

    public static void main(String args[]) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        int n = arr.length;
        System.out.println("The minimum element is " + findMin(arr, 0, n - 1));
    }
}

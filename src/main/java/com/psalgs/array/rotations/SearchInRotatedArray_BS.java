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
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * Search an element in a sorted and rotated array
 *
 * Time Complexity O(log n)
 *
 */
public class SearchInRotatedArray_BS {

    private static int search(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        // Key found return the index
        if (arr[mid] == key) {
            return mid;
        }

        // Is this the sorted array half
        if (arr[low] <= arr[mid]) {
            /* As this subarray is sorted, we can quickly
           check if key lies in half or other half */
            if (key >= arr[low] && key <= arr[mid]) {
                return search(arr, low, mid - 1, key);
            }
            return search(arr, mid + 1, high, key);
        }

        // If arr[l..mid] is not sorted, then arr[mid...h] must be sorted
        if (key >= arr[mid] && key <= arr[high]) {
            return search(arr, mid + 1, high, key);
        }
        return search(arr, low, mid - 1, key);
    }

    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 1;
        int i = search(arr, 0, n - 1, key);

        if (i != -1) {
            System.out.println("Index: " + i);
        } else {
            System.out.println("Key not found");
        }
    }
}

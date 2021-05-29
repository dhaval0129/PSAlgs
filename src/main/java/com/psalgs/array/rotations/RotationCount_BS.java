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
 * http://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 *
 * Find rotation count in rotated array
 *
 * Time Complexity O(log n)
 * Auxiliary Space O(1)
 * 
 */
public class RotationCount_BS {

    // Time Complexity O(n)
    private static int countRotations_LS(int arr[], int n) {
        int min_index = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            if (curr > min_index) {
                count++;
                min_index = arr[i];
            }
        }

        return count;
    }

    // Time Complexity O(log n)
    private static int countRotations_BS(int arr[], int low, int high) {
        if (high < low) {
            return 0;
        }

        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;

        //check if element (mid + 1) is minimum element then current mid
        // If yes then we found the rotation point
        if (mid < high && arr[mid + 1] < arr[mid]) {
            return (mid + 1);
        }
        // check if element mid is les then previous element
        // If yes then we found rotation point
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid;
        }

        // check if recusive call needs to be 
        if (arr[high] > arr[low]) {
            return countRotations_BS(arr, low, mid - 1);
        }

        return countRotations_BS(arr, mid + 1, high);
    }

    public static void main(String args[]) {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int n = arr.length;

        System.out.println(countRotations_BS(arr, 0, n - 1));
    }
}

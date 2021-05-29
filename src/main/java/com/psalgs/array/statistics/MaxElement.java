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
 * http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 *
 * Find the maximum element in an array which is first increasing and then
 * decreasing, This array can also be called as bitonic array
 *
 * Time Complexity: O(log n)
 */
public class MaxElement {

    private static int findMaximum(int[] arr, int low, int high) {
        // There are 3 base Cases
        
        /* Only one element is present in arr[low..high]*/
        if (low == high) {
            return arr[low];
        }

        /* If there are two elements and first is 
        greater then the first element is maximum */
        if ((high == low + 1) && arr[low] >= arr[high]) {
            return arr[low];
        }

        /* If there are two elements and second is 
        greater then the second element is maximum */
        if ((high == low + 1) && arr[low] < arr[high]) {
            return arr[high];
        }

        /* same as: low + (high - low)/2; */
        int mid = (low + high) / 2;

        /* If we reach a point where arr[mid] is greater than 
        both of its adjacent elements arr[mid -1] and arr[mid+1] */
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return arr[mid];
        }

        /* If arr[mid] is greater than the next element and smaller 
        than the previous element than maximum lies on left side of mid */
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            return findMaximum(arr, low, mid - 1);
        } else {
            return findMaximum(arr, mid + 1, high);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int n = arr.length;
        System.out.println("The maximum element is " + findMaximum(arr, 0, n - 1));
    }
}

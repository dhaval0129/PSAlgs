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
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 *
 * Segregate 0s and 1s in an array
 *
 * Time Complexity O(n)
 *
 * Note: Overall time complexity O(n ^ 2), ideal way would be to sort the entire
 * array in O(n log n) time
 */
public class SegregateValues {

    private static void segregate0s1s(int[] arr, int n) {
        // counts the no. of zeroes in arr;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }

        // loop fills the arr with 0 until count
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }

        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++) {
            arr[i] = 1;
        }
    }

    // function to print segregated array
    private static void print(int arr[], int n) {
        System.out.print("Array after segregation is ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 0, 1, 1, 1};
        int n = arr.length;

        segregate0s1s(arr, n);
        print(arr, n);
    }
}

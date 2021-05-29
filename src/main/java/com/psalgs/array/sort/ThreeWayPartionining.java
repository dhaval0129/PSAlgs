/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.sort;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
 *
 * https://algs4.cs.princeton.edu/23quicksort/
 *
 * Three way partitioning of an array around a given range
 *
 * Time Complexity : O(n) 
 * Auxiliary Space : O(1)
 *
 */
public class ThreeWayPartionining {

    private static void threeWayPartition(int[] arr, int lowVal, int highVal) {
        int n = arr.length;

        //Initialize existing available positions for smaller (than range) and greater elements
        int start = 0, end = n - 1;

        // Traverse elements from left
        for (int i = 0; i < end;) {
            // If current element is smaller than
            // range, put it on next available smaller position.
            if (arr[i] < lowVal) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
            } else if (arr[i] > highVal) {
                // If current element is greater than
                // range, put it on next available greater position.
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
            } else {
                i++;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

        threeWayPartition(arr, 10, 20);

        System.out.println("Modified array ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

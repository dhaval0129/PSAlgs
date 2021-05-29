/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/
 *
 * Reorder an array according to given indexes
 *
 * Time Complexity O(n) 
 * Space Complexity O(1)
 *
 */
public class ReorderArray {

    private static int arr[] = {50, 40, 70, 60, 90};
    private static int index[] = {3, 0, 4, 1, 2};

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static void reorder() {
        int n = arr.length;
        int temp[] = new int[n];

        for (int i = 0; i < n; i++) {
            temp[index[i]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
            index[i] = i;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    private static void reorder_optimized() {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int val = index[i];
            
            // swap the array values
            int temp = arr[i];
            arr[i] = arr[val];
            arr[val] = temp;
            
            // swap the index values
            temp = index[i];
            index[i] = index[val];
            index[val] = temp;
        }
    }

    public static void main(String[] args) {
        reorder_optimized();

        System.out.println("Reordered array is: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Modified Index array is:");
        System.out.println(Arrays.toString(index));

    }
}

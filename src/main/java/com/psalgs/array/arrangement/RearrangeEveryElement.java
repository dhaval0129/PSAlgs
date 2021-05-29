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
 * http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
 *
 * Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’
 *
 * Time Complexity O(n) 
 * Space Complexity O(1)
 *
 */
public class RearrangeEveryElement {

    // Time Complexity O(n)
    // Space Complexity O(n)
    private void rearrangeNaive(int arr[]) {
        int n = arr.length;
        // Create an auxiliary array of same size
        int temp[] = new int[n];

        // Store result in temp[]
        for (int i = 0; i < n; i++) {
            temp[arr[i]] = i;
        }

        // Copy temp back to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Time Complexity O(n)
    // Space Complexity O(1)
    private void rearrangeOptimized(int arr[]) {
        int val = 0;
        int i = arr[0];

        while (i != 0) {
            int new_i = arr[i];
            arr[i] = val;
            
            val = i;
            i = new_i;
        }
        
        arr[0] = val;
    }

    // A utility function to print contents of arr[0..n-1]
    private void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        RearrangeEveryElement arrange = new RearrangeEveryElement();
        int arr[] = {1, 3, 0, 2};
        int n = arr.length;

        System.out.println("Given array is ");
        arrange.printArray(arr, n);

        arrange.rearrangeOptimized(arr);

        System.out.println("Modified array is ");
        arrange.printArray(arr, n);
    }
}

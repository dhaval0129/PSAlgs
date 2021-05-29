/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.heap;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 *
 * k largest(or smallest) elements in an array | added Min Heap method
 */
public class KthLargest {

    public static void kLargest(Integer[] arr, int k) {
        // Sort the given array arr in reverse order
        // This method doesn't work with primitive data
        // types. So, instead of int, Integer type 
        // array will be used 
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements 
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Integer arr[] = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        kLargest(arr, k);
    }
}

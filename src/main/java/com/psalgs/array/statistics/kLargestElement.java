/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 *
 * 1) Sort the elements in descending order in O(nLogn)
 *
 * 2) Print the first k numbers of the sorted array O(k).
 *
 * Time complexity: O(n*log(n)) for quick sort and merge sort
 */
public class kLargestElement {

    private static void kLargest(Integer[] arr, int k) {
        // Sort the given array arr in reverse order
        // This method does't work with primitive data types
        // so instead of int , Integer type array is used.
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements 
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        kLargest(arr, k);
    }
}

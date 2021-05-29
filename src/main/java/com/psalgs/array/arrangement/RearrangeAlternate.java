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
 * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 *
 * Rearrange an array in maximum minimum form
 *
 */
public class RearrangeAlternate {

    private static int[] rearrange(int[] arr, int n) {
        // Auxiliary array to hold modified array
        int temp[] = new int[n];
        int start = 0;
        int end = n - 1;
        
        //indexes of smallest and largest elements from remaining array
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (flag) {
                temp[i] = arr[end--];
            } else {
                temp[i] = arr[start++];
            }
            flag = !flag;
        }
        // Copy temp[] to arr[]
        return arr = temp.clone();
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));
        
        int n = arr.length;
        arr = rearrange(arr, n);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(arr));
    }
}

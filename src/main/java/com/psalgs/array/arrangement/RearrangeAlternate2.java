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
 * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 *
 * Rearrange an array in maximum minimum form O(1) Space
 *
 * Time Complexity O(n/2)
 * Space Complexity O(1)
 * 
 */
public class RearrangeAlternate2 {

    private static int[] rearrange(int[] arr, int n) {

        for (int i = 0; i < n/2; i+=2) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        
        return arr;
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

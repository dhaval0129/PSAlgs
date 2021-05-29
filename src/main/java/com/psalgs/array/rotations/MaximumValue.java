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
 * http://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 *
 * http://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
 * 
 * Refer:
 * 
 * http://www.ideserve.co.in/learn/maximum-value-of-index-element-product-sum-with-only-rotations
 * 
 * Find maximum value of Sum( i*arr[i]) with rotations on given array allowed
 * 
 * Time Complexity O(n)
 *
 */
public class MaximumValue {

    private static int maxSum(int[] arr) {
        int n = arr.length;
        // Find array sum and i * arr[i] with no rotation
        int arrSum = 0;   // Stores sum of arr[i]
        int currVal = 0;  // Stores sum of i*arr[i]

        for (int i = 0; i < n; i++) {
            arrSum = arrSum + arr[i];
            currVal = currVal + (i * arr[i]);
        }

        // Initialize result as 0 rotation sum
        int maxVal = currVal;

        //Try all rotation one by one and find maximum sum
        for (int j = 1; j < n; j++) {
            currVal += arrSum - n * arr[n - j];
            if (currVal > maxVal) {
                maxVal = currVal;
            }
        }
        // Return result
        return maxVal;
    }

    public static void main(String args[]) {
//        int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int arr[] = {1, 2, 3, 4};
        int arr[] = {8, 3, 1, 2};
        System.out.println("Max sum is " + maxSum(arr));
    }
}

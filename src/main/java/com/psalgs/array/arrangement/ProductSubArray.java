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
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 *
 * find the product of the maximum product sub-array
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class ProductSubArray {

    private static int maxSubArrayProduct(int[] arr) {
        int n = arr.length;
        int product = 1; // init
        int max = 0, prev_max = 0;

        for (int i = 0; i < n; i++) {
            int temp = Math.abs(arr[i]);

            product *= temp;

            if (product > max) {
                max = product;
            }

            if (product == 0) {
                prev_max = max;
                max = 0;
                product = 1;
            }
        }

        int result = (prev_max > max) ? prev_max : max;
        return result;
    }

    public static void main(String args[]) {
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println("Maximum Sub array product is " + maxSubArrayProduct(arr));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 *
 * Maximum Sum Path in Two Arrays
 *
 * Time Complexity O( m + n)
 * 
 */
public class MaxSumPath {

    private static int maxPathSum(int[] arr1, int[] arr2, int m, int n) {
        int i = 0, j = 0;
        int result = 0, sum1 = 0, sum2 = 0;

        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                // arr2[j] < arr1[i];
                sum2 += arr2[j++];
            } else {
                result += Math.max(sum1, sum2);

                // Update sum1 and sum2 for elements after this intersection point
                sum1 = 0;
                sum2 = 0;

                // Keep updating result while there are more common elements
                while (i < m && j < n && arr1[i] == arr2[j]) {
                    result += arr1[i++];
                    j++;
                }
            }
        }

        // Add remaining elements of ar1[]
        while (i < m) {
            sum1 += arr1[i++];
        }

        // Add remaining elements of ar2[]
        while (j < n) {
            sum2 += arr2[j++];
        }

        // Add maximum of two sums of remaining elements
        result += Math.max(sum1, sum2);

        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 7, 10, 12, 15, 30, 34};
        int arr2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        int m = arr1.length;
        int n = arr2.length;
        System.out.println("Maximum sum path is :" + maxPathSum(arr1, arr2, m, n));
    }
}

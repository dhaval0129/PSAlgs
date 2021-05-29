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
 * http://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
 *
 * Find the closest pair from two sorted arrays, closest to X value
 *
 * Time Complexity O(n)
 */
public class ClosestPair {

    private static void printClosest(int[] arr1, int[] arr2, int m, int n, int x) {
        // Initialize the diff between pair sum and x
        int diff = Integer.MAX_VALUE;

        // res_l and res_r are result indexes from arr1[] and arr2[]
        int res_l = 0, res_r = 0;

        // start from left side of arr1[] and right side of arr2[]
        int l = 0, r = n - 1;

        while (l < m && r >= 0) {
            // If this pair is closer to x than the previously found closest
            // then update res_l, res_r and diff
            if (Math.abs(arr1[l] + arr2[r] - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(arr1[l] + arr2[r] - x);
            }
            // If sum of this pair is more than x, move to smaller side
            if (arr1[l] + arr2[r] > x) {
                r--;
            } else {
                l++;
            }
        }

        // Print the result
        System.out.print("The closest pair is [" + arr1[res_l] + "," + arr2[res_r] + "]");
    }

    public static void main(String args[]) {
        int arr1[] = {1, 4, 5, 7};
        int arr2[] = {10, 20, 30, 40};
        int m = arr1.length;
        int n = arr2.length;
        int x = 38;
        printClosest(arr1, arr2, m, n, x);
    }
}

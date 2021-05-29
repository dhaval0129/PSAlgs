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
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 *
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 *
 */
public class FindMaximum {

    private static int maxIndexDiff(int[] arr, int n) {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        // Construct LMin[] such that LMin[i] stores the minimum value
        // from (arr[0], arr[1],....arr[i])
        LMin[0] = arr[0];
        for (i = 1; i < n; i++) {
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        }

        // Construct RMax[] such that RMax[j] stores the maximum value
        // from (arr[j], arr[j+1], arr[j+2]...arr[n-1])
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(arr[j], RMax[j + 1]);
        }

        // Traverse both arrays from left to right to find optimum j - i
        // This process is similar to merge() of merge sort
        i = 0;
        j = 0;
        maxDiff = -1;

        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                ++j;
            } else {
                ++i;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }
}

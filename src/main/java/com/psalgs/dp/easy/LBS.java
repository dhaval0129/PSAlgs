/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 *
 * https://www.youtube.com/watch?v=TWHytKnOPaQ
 *
 * Longest Bitonic Subsequence ( LBS )
 *
 * Bitnoic sequence is sequence which first increases and then decreases
 *
 * Time Complexity: O(n^2) Auxiliary Space: O(n)
 *
 */
public class LBS {

    /*
    lbs() returns the length of the Longest Bitonic Subsequence in
    arr[] of size n. The function mainly creates two temporary arrays
    lis[] and lds[] and returns the maximum lis[i] + lds[i] - 1.
 
    lis[i] ==> Longest Increasing subsequence ending with arr[i]
    lds[i] ==> Longest decreasing subsequence starting with arr[i]
    
    https://www.youtube.com/watch?v=TWHytKnOPaQ
    
     */
    private static int lbs(int arr[], int n) {

        // Allocate memory for LIS[] & LDS[] and initialize LIS values as 1 for all indexes 
        int[] lis = new int[n];
        int[] lds = new int[n];

        lis[0] = lds[n - 1] = 1;

        /* Compute LIS values from left to right */
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        /* Compute LDS values from right to left */
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        /* Return the maximum value of lis[i] + lds[i] - 1 */
        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < n; i++) {
            
            if (lis[i] + lds[i] - 1 > max) {
                
                max = lis[i] + lds[i] - 1;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is " + lbs(arr, n));
    }
}

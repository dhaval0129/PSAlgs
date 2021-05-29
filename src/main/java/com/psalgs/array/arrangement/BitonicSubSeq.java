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
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 *
 * https://www.youtube.com/watch?v=TWHytKnOPaQ
 *
 * Longest Bitonic Subsequence
 *
 * Note: Bitonic subsequence is one which is first increasing and then
 * decreasing. It is different from bitonic sub-array.
 *
 * Time Complexity O(n ^ 2)
 * Auxiliary Space: O(n)
 *
 */
public class BitonicSubSeq {

    private static int BitonicSeq(int arr[], int n) {
        int[] lis = new int[n];
        int[] lds = new int[n];
        // init last and first element to 1 for lbs and lds array
        lis[0] = lds[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < n; i++) {
            if (lis[i] + lds[i] - 1 > max) {
                max = lis[i] + lds[i] - 1;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
            13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is " + BitonicSeq(arr, n));
    }
}
